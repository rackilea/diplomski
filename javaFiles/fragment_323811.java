public class VowelThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create the list that will contain all the tasks
        List<FutureTask<Integer>> futures = new ArrayList<>();
        for (String str : args) {
            // Create a task for the current String
            FutureTask<Integer> future = new FutureTask<>(new CountVowel(str));
            // Add the task to the list of tasks
            futures.add(future);
            // Provide the task to a new Thread and start it
            new Thread(future).start();
        }
        int total = 0;
        // Iterate over all the tasks
        for (FutureTask<Integer> task : futures) {
            // Wait as long as it is needed to get the result of the current task
            total += task.get();
        }
        // Print the total of vowels found
        System.out.printf("Number of vowels: %d%n", total);
    }
}