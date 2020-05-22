public static class MyClass {
  private String f;

  @XmlAttribute
  @XmlSchemaType(name="double")
  public String getF() {
    return f;
  }
}