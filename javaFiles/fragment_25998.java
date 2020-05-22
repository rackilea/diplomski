@Module(library = true)
public final class FooModule {
  @Provides @Singleton provideFoo() {
    return Foo();
  }
}