public class thread implements Runnable {

public void run() {
System.out.println("run.");
throw new RuntimeException("Problem");
}
public static void main(String[] args) throws InterruptedException {
Thread t = new Thread(new thread());
t.start();
t.join();
System.out.println("End of method.");
}
}