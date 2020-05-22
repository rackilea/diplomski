public class SomeClass {

  @Inject
  private RequestProcessorFactory requestProcessorFactory;

  private void someMethod() {
    ExecutorService pool = Executors.newCachedThreadPool();
    ServerSocket server = new ServerSocket(25000);
    Socket client = server.accept();
    pool.execute(requestProcessorFactory.createNewProcessor(client));
  }
}