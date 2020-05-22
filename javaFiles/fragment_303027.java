class MyValueObject {
  private String value;

  @JsonCreator
  public MyValueObject(String value) { this.value = value; }

  @JsonValue
  public String getValue() { return value; }
}