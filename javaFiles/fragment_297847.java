public class SomeClass {

  @Inject
  private PhoneService phoneService;

  private void someMethod() {
    ExecutorService pool = Executors.newCachedThreadPool();
    ServerSocket server = new ServerSocket(25000);
    Socket client = server.accept();
    pool.execute(new RequestProcessor(client, phoneService));
  }
}