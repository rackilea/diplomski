public class Setup {
  private volatile boolean inited = false;

  private ApplicationContext ctx;

  public boolean isInited() { return inited; }

  public ApplicationContext getContext() { return ctx; }

  public void init() {
    ctx = new ClassPathXmlApplicationContext("context.xml");
    inited = true; // volatile write
  }
}

public class Processor {
  private void ensureInit() {
    while(!setup.isInited()) { // volatile read
      Thread.sleep(1000);
    }
  }

  public void doStuff() {
    ensureInit();
    // at this point we know the context is fully initialized
  }
}