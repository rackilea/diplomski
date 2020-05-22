@Provides
static Bar provideBar() {
    return Bar.create("xxx");
}

@Module
class MyModule {
  @Provides @IntoSet
  static Map.Entry<Foo, Provider<Bar>> entry(
      Provider<Bar> barProvider) {
    Foo key = ...;
    return new SimpleImmutableEntry(key, barProvider);
  }
}

@Module
class MyProviderMapModule {
  @Provides
  static Map<Foo, Provider<Bar>> fooBarProviderMap(
      Set<Map.Entry<Foo, Provider<Bar>>> entries) {
    return ...;
  }
}