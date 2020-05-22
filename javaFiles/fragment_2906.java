// Java environment:
// java version "1.6.0_0"
// OpenJDK Runtime Environment (IcedTea6 1.6.1) (6b16-1.6.1-3ubuntu3)
// OpenJDK 64-Bit Server VM (build 14.0-b16, mixed mode)
public class Test2 extends Thread {
    boolean keepRunning = true;
    public static void main(String[] args) throws InterruptedException {
        Test2 t = new Test2();
        t.start();
        Thread.sleep(1000);
        t.keepRunning = false;
        System.out.println(System.currentTimeMillis() + ": keepRunning is false");
    }
    public void run() {
        while (keepRunning) 
        {}
    }
}