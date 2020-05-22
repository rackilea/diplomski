/**
 * A Multiton where the keys are an enum and each key can create its own value.
 *
 * The create method of the key enum is guaranteed to only be called once.
 *
 * Probably worth making your Multiton static to avoid duplication.
 *
 * @param <K> - The enum that is the key in the map and also does the creation.
 */
public class Multiton<K extends Enum<K> & Multiton.Creator> {
  // The map to the future.
  private final ConcurrentMap<K, Future<Object>> multitons = new ConcurrentHashMap<K, Future<Object>>();

  // The enums must create
  public interface Creator {
    public abstract Object create();

  }

  // The getter.
  public <V> V get(final K key, Class<V> type) {
    // Has it run yet?
    Future<Object> f = multitons.get(key);
    if (f == null) {
      // No! Make the task that runs it.
      FutureTask<Object> ft = new FutureTask<Object>(
              new Callable() {

                public Object call() throws Exception {
                  // Only do the create when called to do so.
                  return key.create();
                }

              });
      // Only put if not there.
      f = multitons.putIfAbsent(key, ft);
      if (f == null) {
        // We replaced null so we successfully put. We were first!
        f = ft;
        // Initiate the task.
        ft.run();
      }
    }
    try {
      /**
       * If code gets here and hangs due to f.status = 0 (FutureTask.NEW)
       * then you are trying to get from your Multiton in your creator.
       *
       * Cannot check for that without unnecessarily complex code.
       *
       * Perhaps could use get with timeout.
       */
      // Cast here to force the right type.
      return type.cast(f.get());
    } catch (Exception ex) {
      // Hide exceptions without discarding them.
      throw new RuntimeException(ex);
    }
  }

  enum E implements Creator {
    A {

              public String create() {
                return "Face";
              }

            },
    B {

              public Integer create() {
                return 0xFace;
              }

            },
    C {

              public Void create() {
                return null;
              }

            };
  }

  public static void main(String args[]) {
    try {
      Multiton<E> m = new Multiton<E>();
      String face1 = m.get(E.A, String.class);
      Integer face2 = m.get(E.B, Integer.class);
      System.out.println("Face1: " + face1 + " Face2: " + Integer.toHexString(face2));
    } catch (Throwable t) {
      t.printStackTrace(System.err);
    }
  }

}