public class Test {
    public static void main(String args[])
        throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("0");
                method();
            }
        });
        thread.start();
        long endTimeMillis = System.currentTimeMillis() + 10000;
        while (thread.isAlive()) {
            if (System.currentTimeMillis() > endTimeMillis) {
                System.out.println("1");
                break;
            }
            try {
                System.out.println("2");
                Thread.sleep(500);
            }
            catch (InterruptedException t) {}
        }


    }

    static void method() {
        long endTimeMillis = System.currentTimeMillis() + 10000;
        while (true) {
            // method logic
            System.out.println("3");
            if (System.currentTimeMillis() > endTimeMillis) {
                // do some clean-up
                System.out.println("4");
                return;
            }
        }
    }
}