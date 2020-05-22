public class Deserializer<T> implements JsonDeserializer<JsonList<T>> {

  public static <T> Deserializer<T> newInstance(Class<T> c) {
    return new Deserializer<T>(c);
  }

  private final Class<T> clazz;
  private Deserializer(Class<T> c) { this.clazz = c; }

  public T someMethod(){
    ...
    T tag = gson.fromJson(obj, clazz); // takes a class e.g. something.class
    ...
  }                       
}