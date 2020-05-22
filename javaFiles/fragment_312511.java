package pk1;

    class Work implements Runnable {

        final public int size = 100;
        private int[] a = new int[size];
        public int[] from = new int[2];
        public int[] to = new int[2];

        public void run() {
        int tn = Integer.parseInt(Thread.currentThread().getName());
        for (int k = from[tn]; k <= to[tn]; k++) {
            a[k] = a[k] ^ 2;

            System.out.println("Working on element " + (tn == 1 ? "\t" : "") + k);
            try {
            Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        }

    }

    public class C1 {

        public static void main(String[] args) {

        Work w1 = new Work();

        w1.from[0] = 0;
        w1.to[0] = w1.size / 2 - 1;

        w1.from[1] = w1.size / 2;
        w1.to[1] = w1.size - 1;

        Thread t1 = new Thread(w1, "0");
        Thread t2 = new Thread(w1, "1");
        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive())
            try {
            Thread.sleep(100);
            } catch (InterruptedException e) {
            }

        }

    }