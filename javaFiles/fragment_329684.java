public class Test {

    static /* volatile */ boolean done = false;

    public static void main(String[] args) throws Exception {
        Runnable waiter = new Runnable() {
            @Override public void run() {
                while(!done);
                System.out.println("Exited loop");
            }
        };
        new Thread(waiter).start();
        Thread.sleep(100); //wait for JIT compilation
        done = true;
        System.out.println("done is true");
    }
}