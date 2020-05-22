@Module
public class AppModule {
  private final Application application;
  private final LoginActivity loginActivity;

  public AppModule(Application application, LoginActivity loginActivity) {
    this.application = application;
    this.loginActivity = loginActivity;
  }

  @Provides
  @Singleton
  Application providesApplication() {
    return mApplication;
  }

  @Provides
  @Singleton
  LoginActivity provideLoginActivity() {
    return loginActivity;
  }
}