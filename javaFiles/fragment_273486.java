public class thread implements Runnable {

public void run() {
System.out.println("run.");
throw new RuntimeException("Problem");
}
public static void main(String[] args) throws InterruptedException {
Thread t = new Thread(new thread());
t.start();
Thread.sleep(3000);
System.out.println("End of method.");
}
}