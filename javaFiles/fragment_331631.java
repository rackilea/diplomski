public static class MyClass {
  private double f;

  @XmlTransient //preventing the mapping
  public double getF() {
    return f;
  }

  @XmlAttribute(name="f")
  @XmlSchemaType(name="double")
  public String getFAsString() {
    return new DecimalFormat("0.00000000").format(f);
  }
}