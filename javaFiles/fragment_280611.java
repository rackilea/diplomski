@Module
class AppModule {

  @Provides
  @Singleton
  @ApplicationContext
  Context provideContext() {
    return mApplication;
  }
}