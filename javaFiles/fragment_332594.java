public class ShowVolatile {

    final static int NUM_THREADS = 1;

    int x = 0;
    volatile int y = 0;

    public static void main(String... args) {

        final ShowVolatile sv = new ShowVolatile();

        for (int i=0; i< NUM_THREADS; i++) {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        sv.x += 1;    
                        sv.y += 1;    
                    }
                }
            }).start();
        }


        while (true) {
            System.out.println("x: " + sv.x + " y: " + sv.y);
        }
    }

}