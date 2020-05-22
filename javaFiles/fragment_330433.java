@FunctionalInterface
public interface A {
  void doIt ();
  default A compose(A next) {
      return () -> { doIt(); next.doIt(); };
  }
}