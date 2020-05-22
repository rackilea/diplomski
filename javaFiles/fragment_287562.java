public class SimpleDateFormatEnosafe {

    private static final SimpleDateFormat format =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        DataFormatter formatter = new DataFormatter();
        for (int i = 0; i < 20; i++) {
            executor.submit(formatter);
        }
        executor.shutdown();
        // NOTE: this could never finish if all but one thread fails in the pool
    }

    private static class DataFormatter implements Runnable {
        @Override
        public void run() {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            while (true) {
                Date date = new Date(random.nextLong());
                String output1 = format.format(date);
                String output2 = format.format(date);
                if (!output1.equals(output2)) {
                    System.out.println(output1 + " != " + output2);
                    break;
                }
            }
        }
    }
}