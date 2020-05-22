import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;

import org.neo4j.graphdb.factory.GraphDatabaseSettings;
import org.neo4j.io.fs.DefaultFileSystemAbstraction;
import org.neo4j.io.fs.FileSystemAbstraction;
import org.neo4j.io.pagecache.PageCache;
import org.neo4j.kernel.configuration.Config;
import org.neo4j.kernel.impl.factory.GraphDatabaseFacadeFactory;
import org.neo4j.kernel.impl.pagecache.ConfiguringPageCacheFactory;
import org.neo4j.kernel.impl.storemigration.StoreVersionCheck;
import org.neo4j.kernel.impl.util.Neo4jJobScheduler;
import org.neo4j.kernel.monitoring.Monitors;
import org.neo4j.kernel.monitoring.tracing.Tracers;
import org.neo4j.logging.Log;
import org.neo4j.logging.Logger;
import org.neo4j.scheduler.JobScheduler;

public class StoreVersionChecker {

    public static String getStoreVersion(File storeDir) {
        File storeFile = new File(storeDir, "neostore");
        if(!storeFile.exists()) {
            return null;
        }
        StoreVersionCheck check = new StoreVersionCheck(buildPageCache());
        try {
            Optional<String> version = check.getVersion(storeFile);
            if(version.isPresent()) {
                return version.get();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static PageCache buildPageCache() {
        FileSystemAbstraction fileSystem = new DefaultFileSystemAbstraction();
        Config config = Config.defaults();
        Log pageCacheLog = new DummyLog();
        String desiredImplementationName = config.get( GraphDatabaseFacadeFactory.Configuration.tracer );
        Monitors monitors = new Monitors();
        JobScheduler jobScheduler = new Neo4jJobScheduler();
        Tracers tracers = new Tracers( desiredImplementationName, new DummyLog(), monitors, jobScheduler );
        ConfiguringPageCacheFactory pageCacheFactory = new ConfiguringPageCacheFactory(fileSystem, config, tracers.pageCacheTracer, tracers.pageCursorTracerSupplier, pageCacheLog );
        PageCache pageCache = pageCacheFactory.getOrCreatePageCache();

        if ( config.get( GraphDatabaseSettings.dump_configuration ) )
        {
            pageCacheFactory.dumpConfiguration();
        }
        return pageCache;
    }

    //We need this so we can give the Tracers a Log
    private static class DummyLog implements Log {

        @Override
        public boolean isDebugEnabled() {return false;}

        @Override
        public Logger debugLogger() {return null;}

        @Override
        public void debug(String message) {}

        @Override
        public void debug(String message, Throwable throwable) {}

        @Override
        public void debug(String format, Object... arguments) {}

        @Override
        public Logger infoLogger() {return null;}

        @Override
        public void info(String message) {}

        @Override
        public void info(String message, Throwable throwable) {}

        @Override
        public void info(String format, Object... arguments) {}

        @Override
        public Logger warnLogger() {return null;}

        @Override
        public void warn(String message) {}

        @Override
        public void warn(String message, Throwable throwable) {}

        @Override
        public void warn(String format, Object... arguments) {}

        @Override
        public Logger errorLogger() {return null;}

        @Override
        public void error(String message) {}

        @Override
        public void error(String message, Throwable throwable) {}

        @Override
        public void error(String format, Object... arguments) {}

        @Override
        public void bulk(Consumer<Log> consumer) {}

    }

}