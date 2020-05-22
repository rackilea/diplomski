class SomethingKey {
  private Something something;
  private final Attributes attributes;
  SomethingKey(Something s) {
    this.something = s;
    this.attributes = attributesFor(something);
  }
  public Result createResult() {
    Something something = this.s;
    this.s = null;
    return something.slowResult();
  }
  public boolean equals(Object o) {
    if(o==this) return true;
    if(o==null || o.getClass() != this.getClass) return false;
    SomethingKey that = (SomethingKey)o;
    return this.attributes.equals(that.attributes);
  }
}