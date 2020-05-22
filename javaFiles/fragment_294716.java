@Module(
    overrides = true,
    library = true,
    injects = { MainActivity.class })
public class MockModule {

  @Provides MyType buildMock() {
    return //...
  }
}