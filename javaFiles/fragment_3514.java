public TestLogic implements Logic{         
  @Override
  public AppConfiguration configuration() {
    return new AppConfiguration(25, "Test", true);
  }
}