class ClientSpecificApp {
  private final CoreService coreService;

  @Inject
  ClientSpecificServiceImpl(@Named("clientName") CoreService coreService) {
    this.coreService = coreService;
  }
}