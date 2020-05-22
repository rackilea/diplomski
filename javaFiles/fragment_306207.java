import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExample {

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        Random rnd = new Random();
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = rnd.nextInt();
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Worker[] workers = new Worker[10];

        int range = numbers.length / 10;
        for (int index = 0; index < 10; index++) {
            int startAt = index * range;
            int endAt = startAt + range;
            workers[index] = new Worker(startAt, endAt, numbers);
        }

        try {
            List<Future<Integer>> results = executor.invokeAll(Arrays.asList(workers));
            for (Future<Integer> future : results) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

    }

    public static class Worker implements Callable<Integer> {

        private int startAt;
        private int endAt;
        private int numbers[];


        public Worker(int startAt, int endAt, int[] numbers) {
            this.startAt = startAt;
            this.endAt = endAt;
            this.numbers = numbers;
        }

        @Override
        public Integer call() throws Exception {
            int max = Integer.MIN_VALUE;
            for (int index = startAt; index < endAt; index++) {
                max = Math.max(numbers[index], max);
            }
            return max;
        }

    }

}