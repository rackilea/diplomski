@Module
public class ApplicationModule {
    @NonNull
    private final Application application;

    public ApplicationModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides
    @NonNull
    @Singleton
    Application provideApp() {
        return application;
    }

    @Provides
    @NonNull
    @Singleton
    B provideB() {
        return new B();
    }

    @Provides
    @NonNull
    @Singleton
    C provideC() {
        return new C();
    }
}