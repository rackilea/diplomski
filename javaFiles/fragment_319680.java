public class FileProcessing {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Thread mainThread = new Thread(new ProducerThread(executorService));
        mainThread.start();
    }

    public static class ProducerThread implements Runnable {
        private ExecutorService executorService;

        public ProducerThread(ExecutorService executorService) throws InterruptedException {
            this.executorService = executorService;
            Thread.sleep(2000);
        }

        @Override
        public void run() {
            for(File f: new File("c:/").listFiles()) {
                if(f.isDirectory()) {
                    try {
                        final String fileName = f.getCanonicalPath();
                        executorService.submit(new Callable<Object>() {
                            @Override
                            public Object call() throws Exception {
                                System.out.println("Processing: " + fileName);
                                return null;
                            }
                        });
                        System.out.println("Added: " + f.getCanonicalPath());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}