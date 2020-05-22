public class Main {
       public static void main(String[] args) {
           ThreadTest test = new ThreadTest("Test", 3);
           test.start();
           System.out.println(test.toString());
       }    


}

public class ThreadTest extends Thread {
    private int x;
       public ThreadTest(String n, int x) {
           setName(n);
           this.x = x;

       }
       @Override
       public String toString() {
           return(getName() + ": x = " + x + " executed on thread " + Thread.currentThread().getName());
       }
       public void run() {
           //Nothing of any relevance to the problem occurs here
       }
}