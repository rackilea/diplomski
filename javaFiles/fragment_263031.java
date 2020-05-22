public class Main {
    public static void main(String[] args) throws Exception {

        // the array to modify
        final int[] array = new int[1000];

        // start the executor (that modifies the array)
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            final int c = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    array[c] = c;
                }
            });
        }

        // wait for all tasks to quit
        executor.shutdown();
        while (!executor.awaitTermination(10, TimeUnit.SECONDS)); 

        // print the array
        System.out.println(Arrays.toString(array));
    }
}