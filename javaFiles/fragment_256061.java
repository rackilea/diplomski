class C {
  // Guice will automatically create an implementation of this interface.
  // This can be defined anywhere, but I like putting it in the class itself.
  interface Factory {
    C create(ConfigurationField passedIn);
  }

  @Inject
  private FactoryClass toBeInjected;

  private ConfigurationField passedIn;
  private SomeOtherDepIfYoudLike otherDep;

  @Inject public C(@Assisted ConfigurationField passedIn,
      SomeOtherDepIfYoudLike otherDep) {
    this.passedIn = passedIn;
    this.otherDep = otherDep;
  }
}