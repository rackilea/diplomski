import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class HelloModule extends AbstractModule {
    protected void configure() {

        bind(MyStartupClass.class)
                .toSelf()
                .asEagerSingleton();
    }
}