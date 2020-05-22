public class Test {

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Foo");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
    }
}