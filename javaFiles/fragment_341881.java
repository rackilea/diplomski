@Configuration
 public class TestApp implements Lifecycle {

  boolean runStatus = false;

  public TestApp (){}


  @Bean
  public TestApp testApp(){
    return new TestApp();
  }

  @Override
  public void start() {
    System.err.println(">> call: start (Lifecycle)");
    runStatus = true;
  }

  @Override
  public void stop() {
    System.err.println(">> call: stop (Lifecycle)");
    runStatus = false;
  }

  @Override
  public boolean isRunning() {
    System.err.println(">> call: is running: " + runStatus);
    return runStatus;
  }

  public static void main(String[] args) {
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(TestApp.class);
    ctx.start();
    TestApp ta = ctx.getBean(TestApp.class);
    ctx.stop();
  }
}