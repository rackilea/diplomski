public class WildcardsExperiment {
  // Defined by a framework.  <begin unmodifiable>
  interface Key<K extends Key<K>> {}
  interface Row<R extends Row<R, K>, K extends Key<K>> {}

  static <R extends Row<R, K>, K extends Key<K>> R copyRow(R row) {
    return row;
  }
  // <end unmodifiable>

  interface NaturalRowTransformer {
    <R extends Row<R, K>, K extends Key<K>> R apply(R r);
  }

  class Wrapper<R extends Row<R, K>, K extends Key<K>> {
    private final R row = null; // fixme (constructor etc.)
    public final Class<R> clazz = null; // fixme

    R invokeNat(NaturalRowTransformer nat) {
      return nat.apply(row);
    }
  }

  static final NaturalRowTransformer CopyRow = new NaturalRowTransformer() {
    public <R extends Row<R, K>, K extends Key<K>> R apply(R row) {
      return copyRow(row);
    }
  };

  public static void main(String[] args) {
    Wrapper<?, ?> wr = null; // fixme
    wr.invokeNat(CopyRow); // compiles
  }
}