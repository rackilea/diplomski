public class WebReaderResult<V> {
   private AtomicReference<V> ref = new AtomicReference<V>();

   public V getResult() { return ref.get(); }
   public void setResult(V value) { ref.set(value); }
}