class RunMe implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing :"+Thread.currentThread().getName());
        for(int i = 1; i <= 5; i++) {
            System.out.println("Inside loop for i = " +i);
        }
        System.out.println("Execution completed");
    }

}

public class Interrupted {

    public static void main(String[] args) {
        RunMe runMe = new RunMe();
        Thread t1 = new Thread(runMe);
        t1.start();
        t1.interrupt();//interrupt ignored
        System.out.println("Interrupt method called to interrupt t1");
    }
}