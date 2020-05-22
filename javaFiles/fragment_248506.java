public class Test {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (;;) {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    System.out.println("Executed");
                }
            }
        }.start();
    }
}