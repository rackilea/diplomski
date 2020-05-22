public class Main {
    private static final char[] alphabet = "eaistnrulodmpcvqgbfjhzxykw0123456789!@#$%&*".toCharArray();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores: " + cores); //8 cores

        int partitionSize = alphabet.length / cores;
        ExecutorService service = Executors.newFixedThreadPool(cores);
        List<Future> futures = new ArrayList<Future>();

        for (int c = 0; c < cores; c++) {

            char[] part = Arrays.copyOfRange(alphabet, c * partitionSize, (c + 1) * partitionSize);
            futures.add(service.submit(new BruteWorker(part)));

        }

        for(Future f : futures)
            f.get();

        service.shutdown();
        System.out.println("Completed normally");
    }
    public static class BruteWorker implements Runnable {
        private char[] partition;


        BruteWorker(char[] partition) {
            this.partition = partition;
        }

        public void run() {
            System.out.println("New thread (id = "+ Thread.currentThread().getId() +")");
            for (long nbTries = 0; nbTries < 1_000_000_000L; nbTries ++ ) {
                if((nbTries % 10_000_000) == 0){
                    System.out.println(nbTries + " tries on thread id = "+ Thread.currentThread().getId());
                }
            }
            System.out.println("End of thread (id = "+ Thread.currentThread().getId() +")");
        }
    }    
}