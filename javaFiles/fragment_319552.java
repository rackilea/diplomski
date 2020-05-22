public static <T extends Comparable<T>> void sort(int[] numberArray) {

        if (numberArray == null || numberArray.length == 0) {
            return;
        }

        final AtomicInteger count = new AtomicInteger(1);
        pool.execute(new QuicksortRunnable<T>(numberArray, 0, numberArray.length - 1, count));

        try {
            synchronized (count) {
                count.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            pool.shutdown(); //call shutdown() here
            try {
                pool.awaitTermination(5, TimeUnit.MINUTES); //wait for 5 minutes
            }catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }