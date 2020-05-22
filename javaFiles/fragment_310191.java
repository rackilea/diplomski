import java.util.*;
import java.util.concurrent.*;

class Example {
    public static void main(String[] args) {
        final int n = 3;
        final int length = 20;

        ExecutorService ex = Executors.newFixedThreadPool(n);
        List<Future<int[]>> futures = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            futures.add(ex.submit(new Callable<int[]>() {
                Random r = new Random();

                @Override
                public int[] call() {
                    int[] result = new int[length];

                    for (int i = 0; i < length; ++i) {
                        int tmp = r.nextInt(length);
                        result[tmp]++;
                    }

                    return result;
                }
            }));
        }

        ex.shutdown();

        for (Future<int[]> f : futures) {
            try {
                System.out.println(Arrays.toString(f.get()));
            } catch (InterruptedException|ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}