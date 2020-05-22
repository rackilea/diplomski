public interface Union<A, B> {
  boolean isA();
  boolean isB();
  A getA();
  B getB();
}