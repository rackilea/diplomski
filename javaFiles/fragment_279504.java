public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input number>>");
        int k = scanner.nextInt();  //input 'k'

        int sum = 0;
        // Make threads number of 'k'. Here we use List instead of array because there is such contract in ExecutorService
        List<Calthread> cal = new ArrayList<>(k);
        // Create thread pool with fixed number of threads
        ExecutorService service = Executors.newFixedThreadPool(k);
        // Add all Callable task in one collection
        for (int i = 0; i < k; i++) {
            cal.add(new Calthread(i+1));
        }
        try {
            // Invoke all Callable task and get List with results
            List<Future<Integer>> results = service.invokeAll(cal);
            // Future::get is blocking method. It waits result.
            for (Future<Integer> result : results) {
                sum += result.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

        System.out.println("Result: " + sum);
        // We need to shutdown our service
        service.shutdown();
    }
}