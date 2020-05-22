public class KeyMap {
  public static class Key<T> { }

  private final HashMap<Object,List<?>> values = new HashMap<Object,List<?>>();

  public <T> void put(Key<T> k, List<T> v) {
    values.put(k, v);
  }

  public <T> List<T> get(Key<T> k) {
    return (List<T>)values.get(k);
  }

  public static void main(String[] args) {
    KeyMap a = new KeyMap();
    a.put(new Key<String>(), new ArrayList<String>());
    a.get(new Key<Integer>());
  }
}