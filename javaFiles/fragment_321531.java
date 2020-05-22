package multithreading1;

import java.util.concurrent.TimeUnit;

public class SingleLaneBridge {

    // count of all farmers
    private volatile static int count = 0;
    // variable used for synchronization in multiple threads
    private static final Integer max_count = 2;

    public static void main(String[] args) {
        final Bridge bridge = new Bridge();

        Thread thNorthbound = new Thread(new Runnable() {

            @Override
            public void run() {

                while (true) {
                    Farmer farmer = new Farmer(bridge);
                    // tracking count of farmers in multiple threads
                    synchronized (max_count) {
                        count++;
                        if (count > max_count)
                            break;
                        farmer.setName("North Farmer " + count);
                    }

                    Thread th = new Thread(farmer);
                    th.start();

                    try {
                        TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                    } catch (InterruptedException iex) {
                        iex.printStackTrace();
                    }
                }

            }
        });

        Thread thSouthbound = new Thread(new Runnable() {

            @Override
            public void run() {

                while (true) {
                    Farmer farmer = new Farmer(bridge);
                    // tracking count of farmers in multiple threads
                    synchronized (max_count) {
                        count++;
                        if (count > max_count)
                            break;
                        farmer.setName("South Farmer " + count);
                    }

                    Thread th = new Thread(farmer);
                    th.start();

                    try {
                        TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                    } catch (InterruptedException iex) {
                        iex.printStackTrace();
                    }
                }
            }
        });

        thNorthbound.start();
        thSouthbound.start();
    }

}