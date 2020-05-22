public class GType<T> {
  private PointConstructor<T> cxor; 
  public GType(PointConstructor<T> cxor) { this.cxor = cxor; }

  public T get(double p1, double p2) { 
    return cxor.create(p1, p2);
  }
}