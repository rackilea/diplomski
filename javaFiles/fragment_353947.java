public class Test extends Thread  {

private String name;

public Test(String name) {
    this.name = name;
}

public synchronized void run() {
    System.out.println(name);

    while(true) 
        { 
        // loop endless
        }
  }

  public static void main(String args[])
  {
    Thread t1= new Test("t1");
    Thread t2= new Test("t2");
    t1.start();
    t2.start();

  }