import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class StartupConfigurationModule extends AbstractModule {
    protected void configure() {

        bind(StartupConfiguration.class)
            .to(StartupConfigurationImpl.class)
            .asEagerSingleton();
    }
}