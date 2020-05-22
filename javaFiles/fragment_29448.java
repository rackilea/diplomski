import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class ParallelImplementationOptimised {
    static final int numberOfThreads = Runtime.getRuntime().availableProcessors();
    final ExecutorService exec = Executors.newFixedThreadPool(numberOfThreads);

    private int numberOfCells;

    public ParallelImplementationOptimised(int numberOfCells) {
        this.numberOfCells = numberOfCells;
    }

    public void update() throws ExecutionException, InterruptedException {

        List<Future<?>> futures = new ArrayList<>();
        for(int thread = 0; thread < numberOfThreads; thread++) {
            final int threadId = thread;
            futures.add(exec.submit(new Runnable() {
                @Override
                public void run() {
                    int num = numberOfCells / numberOfThreads;
                    double[] h0 = new double[num],
                            h1 = new double[num],
                            h2 = new double[num],
                            h3 = new double[num],
                            h4 = new double[num],
                            h5 = new double[num],
                            h6 = new double[num],
                            h7 = new double[num],
                            h8 = new double[num],
                            h9 = new double[num];
                    for (int i = 0; i < num; i++) {
                        h0[i] = h0[i] + 1;
                        h1[i] = h1[i] + 1;
                        h2[i] = h2[i] + 1;
                        h3[i] = h3[i] + 1;
                        h4[i] = h4[i] + 1;
                        h5[i] = h5[i] + 1;
                        h6[i] = h6[i] + 1;
                        h7[i] = h7[i] + 1;
                        h8[i] = h8[i] + 1;
                        h9[i] = h9[i] + 1;
                    }
                }
            }));
        }
        for (Future<?> future : futures) {
            future.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ParallelImplementationOptimised si = new ParallelImplementationOptimised(10);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            if(i % 1000 == 0) {
                System.out.println(i);
            }
            si.update();
        }

        long stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start));
        si.exec.shutdown();
    }

}