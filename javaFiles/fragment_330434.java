@FunctionalInterface
public interface A extends Runnable {
    default void doIt() { run(); }
    default A compose(Runnable next) {
      return () -> { doIt(); next.run(); };
  }
}