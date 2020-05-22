class ColorPair {
  private String name;
  private String hex;

  public ColorPair(String name, String hex) {
    this.name = name;
    this.hex = hex;
  }

  public String getName() {
    return name;
  }

  public String getHex() {
    return hex;
  }

  @Override
  public String toString() {
    return String.format("[ColorPair name=%s, hex=%s]", name, hex);
  }
}