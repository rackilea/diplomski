public class Function extends AbstractFunction implements Func {
  public Function(String name, ExecutorService service) {
    super(name, service);
  }

  protected void evaluate() {
    boolean match = dependsOn.stream().allMatch(Func::isComplete);

    if (match) {
      this.isComplete = false;

      // inform each observer that I'm about to start to evaluate
      observedBy.forEach(func -> func.onDependentEvaluate(this));

      CompletableFuture.runAsync(() -> {
        try {
          System.out.println("Doing some work");
          int sleepTime = (int) (Math.random() * 5000);
          System.out.println("Working for " + sleepTime);
          Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
          System.out.println("I was interrupted, my name is: " + name);
          e.printStackTrace();
        }
      }, service).thenRun(this::onComplete);
    }
  }

  @Override
  public void change() {
    evaluate();
  }

  @Override
  public void onDependentComplete(Func f) {
    evaluate();
  }
}