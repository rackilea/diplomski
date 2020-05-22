public class Test  {
    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        ExecutorService e = Executors.newFixedThreadPool(2);
        e.execute(new WriterTask());
        e.execute(new ReaderTask());
    }

    static class ReaderTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                for (String s : list) {
                    System.out.println(s);
                }
            }
        }
    }

    static class WriterTask implements Runnable {
        @Override
        public void run() {
            while(true) {
                list.add("a");
            }
        }
    }
}