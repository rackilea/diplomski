public class Request implements Callable<Response> {
  final private URL url;
  final private CountDownLatch latch;

  public Request(URL url, CountDownLatch latch) {
      this.url = url;
      this.latch = latch;
  }

  @Override
  public Response call() throws Exception {

       try {
          return new Response(url.openStream());
       } 
       catch (Exception e) {

          //do something useful
       }
       finally {
          latch.countDown();
       }
  }
}