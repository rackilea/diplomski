public UnionImpl extends AbstractUnion<String, Integer> {
  private String strValue;
  private int intValue

  public UnionImpl(String str) {
    this.strValue = str;
    this.intValue = null;
  }

  // etc.
}