public class Runner
{

    public static void main(String args[]) {
        Runner r = new Runner();
        try {
            r.dowork();
        } catch (IOException e) {
            // handle
            e.printStackTrace();
        }
    }

    CyclicBarrier barrier;
    ExecutorService executor;
    private int totalWorkers = 2;

    public Runner() {
        this.barrier = new CyclicBarrier(this.totalWorkers + 1);
        this.executor = Executors.newFixedThreadPool(this.totalWorkers);
    }

    public synchronized void dowork() throws IOException
    {
        //<code for opening a file here, other setup here, etc>
        //BufferedReader reader = null;
        //String line;

        final Worker worker = new Worker();

        for(String line : new String[]{"Line 1", "Line 2", "Line 3"})
        //while ((line = reader.readLine()) != null)
        {
            System.out.println("Read line: " + line);
            //<a large amount of processing on 'line'>

            for(int c = 0; c < this.totalWorkers; c++) {
                final String curLine = line;
                this.executor.submit(new Runnable() {
                    public void run() {
                        worker.doWork(curLine);
                    }
                });
            }

            try {
                System.out.println("Waiting for work to be complete on line: " + line);
                this.barrier.await();
            } catch (InterruptedException e) {
                // handle
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // handle
                e.printStackTrace();
            }
        }

        System.out.println("All work complete!");
    }

    class Worker
    {
        public void doWork(String line)
        {
            //<do work with this.data here>
            System.out.println("Working on line: " + line);

            try {
                Runner.this.barrier.await();
            } catch (InterruptedException e) {
                // handle
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // handle
                e.printStackTrace();
            }
        }
    }    
}