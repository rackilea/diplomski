public abstract class WebTask<V> {
   private WebReaderResult<V> res = new WebReaderResult<V>();

   public WebReaderResult<V> getWebReaderResult() { return res; }

   // handle task here
   public abstract void handle();
}