public class Test {
    public static long[] arr = new long[20]; // Make this non-volatile now
    public static volatile int vol = 0; // Make another volatile variable

    public static void main(String[] args) throws Exception {
        new Thread(new Thread(){
            @Override
            public void run() {
                //Thread A
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);    
                    arr[19] = 2;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Thread(){
            @Override
            public void run() {
                //Thread B
                while (true) {
                    int i = vol;

                    if (arr[19] == 2) {
                        break;
                    }
                }
                System.out.println("Jump out of the loop!");
            }
        }).start();
    }
}