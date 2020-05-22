public interface WebControllerCallback<V> {
   public void done(V result);
}

public class WebController {
   static private WebController instance;
   static public WebController getInstance() {
      if (null == instance) instance = new WebController();
      return instance;
   }

   private ExecutorService executor = Executors.newSingleThreadExecutor();

   public void handleTask(WebTask<?> t, WebControllerCallback<?> cb) {
      executor.submit(new Runnable() {
         public void run() {
            t.handle();
            cb.done(t.getWebReaderResult());
         }
      });
   }

   // other methods here
}