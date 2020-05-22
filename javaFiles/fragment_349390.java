public class Main {

    private static volatile int i = 0;

    public static void main(String[] args) throws Exception{

        Runnable  first = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread_1 see i = " + i);
                i++;
                System.out.println("Thread_1 set i = " + i);
            }
        };

        Runnable second = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread_2 see i = " + i);
                i++;
                System.out.println("Thread_2 set i = " + i);
            }
        };
        new Thread(first).start();
        new Thread(second).start();
    }
}