public class App {
    private List<String> workItems;
    private AtomicInteger factor = new AtomicInteger(0);

    public App() {
        workItems = new ArrayList<>();
        //create some work in workItmes
        workItems.add("apple");
        workItems.add("oranges");
        workItems.add("bananas");
    }

    public List<String> getWorkItems() {
        return workItems;
    }


    public void calculateFactor() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        factor.set(1);
    }

    public boolean evaluateItem(String item, int factor) {
        // do some work based on item and current factor
        System.out.println("Received: " + item + " " + factor);
        return true;
    }

    public AtomicInteger getFactor() {
        return factor;
    }

    public static void main(String[] args) throws Exception {
        App myApp = new App();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("starting...");
        int cnt = 0;
        while (true) {
            cnt++;
            if (cnt > 5) {
                break;
            }

            executorService.submit(() -> {
                try {
                    myApp.calculateFactor();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Error when calculating Factor");
                }
            });
            int currentFactor = myApp.getFactor().get();
            List<Boolean> results = myApp.getWorkItems().stream().map(s -> myApp.evaluateItem(s, currentFactor)).collect(toList());
            System.out.println(results);
            TimeUnit.SECONDS.sleep(1);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("done");
    }
}