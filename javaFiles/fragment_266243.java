class YourClass {
  // these are final
  private final int x;
  private final int y;

  private int a;
  private int b;

  // finals are passed into the constructor
  private YourClass(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static class Builder {
    // int x, int y, int a, int b
    // whatever's final is passed into constructor
    public Builder(int x, int y) {
      this.x = x;
      this.y = y;
    }
    // a and b are optional, so have with() methods for these
    public Builder withA(int a) {
      this.a = a;
      return this;
    }
    public Builder withB(int b) {
      this.b = b;
      return this;
    }
    public YourClass build() {
      YourClass c = new YourClass (x, y);
      c.a = a;
      c.b = b;
      return c;
    }
  }
}