public class Test  {
    private static List<String> list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) throws Exception {
        ExecutorService e = Executors.newFixedThreadPool(5);
        e.execute(new WriterTask());
        e.execute(new WriterTask());
        e.execute(new WriterTask());
        e.execute(new WriterTask());
        e.execute(new WriterTask());

        e.awaitTermination(20, TimeUnit.SECONDS);
    }

    static class WriterTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 25000; i ++) {
                list.add("a");
            }
        }
    }
}