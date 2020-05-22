@Path("/async/longRunning")
public class MyResource {

   @GET
   public void longRunningOp(@Suspended final AsyncResponse ar) {
       executor.submit(
            new Runnable() {
                public void run() {
                    executeLongRunningOp();
                    ar.resume("Hello async world!");
                } });
  }
}