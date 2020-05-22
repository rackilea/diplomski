public abstract class SuperClass {

   public SuperClass() {
       new Thread("evil") { public void run() {
          doSomethingDangerous();
       }}).start();
       try {
          Thread.sleep(5000);
       }
       catch(InterruptedException ex) { /* ignore */ }
   }

   public abstract void doSomethingDangerous();

}

public class SubClass extends SuperClass {
    int number;
    public SubClass () {
        super();
        number = 2;
    }

    public synchronized void doSomethingDangerous() {
        if(number == 2) {
            System.out.println("everything OK");
        }
        else {
            System.out.println("we have a problem.");
        }
    }

}