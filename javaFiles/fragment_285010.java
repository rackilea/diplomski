@Module
abstract class ServicesModule {

  @ContributesAndroidInjector
  abstract SomeService ProvideSomeService();
}