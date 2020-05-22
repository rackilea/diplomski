public static void loadWithThreads(File[] array) {

    final int threads = Runtime.getRuntime().availableProcessors();
    t = new Thread[threads];

    CountDownLatch latch = new CountDownLatch(threads);

    for (int i = 0; i < threads; i++) {
        t[i] = new Thread("HMediaConverter") {
            final int id = currentThreads;

            int items = (array.length / threads) * currentThreads;

            @Override
            public void run() {
                try {
                    System.out.println("Starting " + id);

                    for (int i = items; i < (items + (array.length / threads)); i++) {
                        try {
                            System.out.println(i + ": " + array[i]);
                            ImageIO.read(array[i]);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                } finally {
                    latch.countDown();
                }

            }

        };
        t[i].setPriority(Thread.MAX_PRIORITY);
        System.out.println("Start " + i);
        t[i].start();
        currentThreads++;
    }

    try {
        latch.await();
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
}