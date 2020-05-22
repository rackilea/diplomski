import java.util.Arrays;
import java.util.concurrent.*;

public class Threadspawns {
    private final int THREAD_COUNT = 8;
    private final int CALCULATION_COUNT = 60000;
    private double[] arr = new double[CALCULATION_COUNT];

    public void calculations() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        ExecutorCompletionService<Double> completionService = new ExecutorCompletionService<Double>(executorService);
        for (int i = 2; i < CALCULATION_COUNT; i++) {
            completionService.submit(new Calculation(i));
        }

        //Get from all Future tasks till all tasks completed
        for (int i = 2; i < CALCULATION_COUNT; i++) {
            try {
                arr[i] = completionService.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();  //do something
            } catch (ExecutionException e) {
                e.printStackTrace();  //do something
            }
        }
    }

    private static class Calculation implements Callable<Double> {
        private final int num;

        private Calculation(int num) {
            this.num = num;
        }

        @Override
        public Double call() throws Exception {
            return Math.pow(num, 500);
        }
    }

    public static void main(String[] args) {
        Threadspawns t = new Threadspawns();
        long start = System.currentTimeMillis();
        t.calculations();
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(t.arr));
        System.out.println("time taken " + (end - start));
    }
}