public class MyJob extends Job<Object> {
   private Request request;
   public MyJob() {
      request = Request.current();
   }
   public void doJob() {
      // here you use the request object
   }
}