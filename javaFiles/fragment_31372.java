public class MyClass<T> {
   private Map<String, T> map;

   public T getObject(final String key) {
    return map.get(key);
   }
}