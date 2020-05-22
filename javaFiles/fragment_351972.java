class MyClass {
  @Getter
  @Setter
  int a;

  @Getter
  @Setter
  int b;

  @JsonProperty
  public int getADivB() {
    return a / b;
  }
}