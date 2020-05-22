public static class Test {
  private String something;
  public Optional<String> getSomething() {
    return Optional.ofNullable(something);
  }
  public void setSomething(String something) {
    this.something = something;
  }
}