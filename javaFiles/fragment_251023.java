public class Test implements Runnable {
  public static ThreadLocal<String> myString = new ThreadLocal<String>();
  private String myInitialString;
  public Test(String someString) {
    myInitialString = someString;
  }

  public void run() {
    myString.set(myInitialString);
    System.out.println(myString.get());
    myString.set(myString.get() + " changed");
    System.out.println(myString.get());
    new OtherTest().printTheString();
  }

  public static void main(String[] args) throws InterruptedException {
    Thread[] threads = new Thread[3];
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new Test("Thread" + i));
      threads[i].start();
    }
    for (int i = 0; i < threads.length; i++) {
      threads[i].join();
    }
  }
}

class OtherTest{
  public void printTheString(){
    System.out.println(Test.myString.get()+" OtherTest");
  }
}