public class ShutdownFunc extends AbstractFunction {
  public ShutdownFunc(String name, ExecutorService service) {
    super(name, service);
  }

  @Override
  public void onDependentComplete(Func f) {
    System.out.println("Shutting down the system");
    try {
      service.shutdown();
      service.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}