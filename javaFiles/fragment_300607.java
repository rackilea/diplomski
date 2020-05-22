public enum ClientFactory {
  INSTANCE;

  public Company getClient() {
    return new Company();
  }
}