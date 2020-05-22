public class ThreadTest {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.printf("Main, Which Thread: %s, %d%n", 
                currentThread.getName(), 
                currentThread.getId());

        Abc abc = new Abc();
        abc.start();
    }
}