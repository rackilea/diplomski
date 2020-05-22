public class AModule extends AbstractModule {
  @Override public void configure() {
    // Install your AFactory module. Here, injections for AFactory should succeed.
    install(new FactoryModuleBuilder().build(AFactory.class));
  }

  /**
   * Provides a singleton @Named("consistent") A.
   * Inject @Named("consistent") A into B, C, and D; Guice will cache the instance.
   */
  @Provides @Singleton @Named("consistent")
      A provideConsistentA(AFactory factory) {
    return factory.create(100, "mike");
  }

  /**
   * Provides an unscoped A.
   * Inject A without an annotation into E and F; each instance will be separate.
   */
  @Provides @Singleton A provideUnscopedA(AFactory factory) {
    return factory.create(200, "jeff");
  }
}