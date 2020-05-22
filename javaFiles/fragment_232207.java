public class Test implements Runnable {
  Thread runner;
  public Test() {
    this.runner = new Thread(this);
    this.runner.start();
  }

  @Override
  public void run() {
    System.out.println("ya");   
  }

  public static void main(String[] args) {
    new Test();
  }
}