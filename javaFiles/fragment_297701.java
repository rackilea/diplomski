public class LockExample {
    private static synchronized void methodOne(int depth) {
        if (depth == 0) {
            return;
        } else {
            System.out.println(Thread.currentThread().getName() + " methodOne (in), depth " + depth);
            methodTwo(depth - 1);
            System.out.println(Thread.currentThread().getName() + " methodOne (out), depth " + depth);
        }
    }

    private static synchronized void methodTwo(int depth) {
        if (depth == 0) {
            return;
        } else {
            System.out.println(Thread.currentThread().getName() + " methodTwo (in), depth " + depth);
            methodOne(depth - 1);
            System.out.println(Thread.currentThread().getName() + " methodTwo (out), depth " + depth);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    methodOne(10);
                }
            });
            t.setName("Thread" + i);
            t.start();
        }
    }
}