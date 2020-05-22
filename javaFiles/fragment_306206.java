import java.util.Random;

public class ThreadExample {

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        Random rnd = new Random();
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = rnd.nextInt();
        }

        Thread[] threads = new Thread[10];
        Worker[] workers = new Worker[10];

        int range = numbers.length / 10;
        for (int index = 0; index < 10; index++) {
            int startAt = index * range;
            int endAt = startAt + range;
            workers[index] = new Worker(startAt, endAt, numbers);
        }

        for (int index = 0; index < 10; index++) {
            threads[index] = new Thread(workers[index]);
            threads[index].start();
        }

        boolean isProcessing = false;
        do {
            isProcessing = false;
            for (Thread t : threads) {
                if (t.isAlive()) {
                    isProcessing = true;
                    break;
                }
            }
        } while (isProcessing);

        for (Worker worker : workers) {
            System.out.println("Max = " + worker.getMax());
        }

    }

    public static class Worker implements Runnable {

        private int startAt;
        private int endAt;
        private int numbers[];

        private int max = Integer.MIN_VALUE;

        public Worker(int startAt, int endAt, int[] numbers) {
            this.startAt = startAt;
            this.endAt = endAt;
            this.numbers = numbers;
        }

        @Override
        public void run() {
            for (int index = startAt; index < endAt; index++) {
                max = Math.max(numbers[index], max);
            }
        }

        public int getMax() {
            return max;
        }

    }

}