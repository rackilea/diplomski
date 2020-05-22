@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    BaseNavigator provideNavigator(Navigator navigator) {
        return navigator;
    } // this will return interface type but with implementation you needed

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

}