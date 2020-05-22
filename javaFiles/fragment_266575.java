import java.io.File;

import org.neo4j.io.fs.DefaultFileSystemAbstraction;
import org.neo4j.io.fs.FileSystemAbstraction;
import org.neo4j.kernel.impl.transaction.log.LogTailScanner;
import org.neo4j.kernel.impl.transaction.log.PhysicalLogFile;
import org.neo4j.kernel.impl.transaction.log.PhysicalLogFiles;
import org.neo4j.kernel.impl.transaction.log.ReadableClosablePositionAwareChannel;
import org.neo4j.kernel.impl.transaction.log.entry.LogEntryReader;
import org.neo4j.kernel.impl.transaction.log.entry.LogEntryVersion;
import org.neo4j.kernel.impl.transaction.log.entry.VersionAwareLogEntryReader;

public class Neo4jVersionChecker {

    //Note that this method needs the store directory NOT the debug.log file
    public static String getNeo4jVersion(File storeDir) {   
        FileSystemAbstraction fileSystem = new DefaultFileSystemAbstraction();
        final PhysicalLogFiles logFiles = new PhysicalLogFiles( storeDir, PhysicalLogFile.DEFAULT_NAME, fileSystem );
        final LogEntryReader<ReadableClosablePositionAwareChannel> logEntryReader = new VersionAwareLogEntryReader<>();
        LogTailScanner tailScanner = new LogTailScanner( logFiles, fileSystem, logEntryReader );

        LogEntryVersion version = tailScanner.getTailInformation().latestLogEntryVersion;

        if(version!=null) {
                return version.toString();
        } else {
                return null;
        }
    }

}