class DefaultApp {
  private final CoreService coreService;

  @Inject
  DefaultApp(CoreService coreService) {
    this.coreService = coreService;
  }
}