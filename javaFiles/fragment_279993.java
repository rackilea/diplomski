public final class Pair {
  private final Object a;
  private final Object b;

  public Pair(Object a, Object b) {
    this.a = a; 
    this.b = b;
  }

  @Override public boolean equals(Object o) {
    if(o == null || !(o instanceof Pair)) 
      return false;

    Pair that = (Pair) o;
    return this.a.equals(that.a) && this.b.equals(that.b) 
      || this.a.equals(that.b) && this.b.equals(that.a);
  }

  @Override public int hashCode() {
    return a.hashCode() ^ b.hashCode();
  }
}