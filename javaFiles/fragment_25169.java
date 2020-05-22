public class CyclicBarrierExample
{
    private static int matrix[][] = 
    { 
        { 1 }, 
        { 2, 2 }, 
        { 3, 3, 3 },
        { 4, 4, 4, 4 }, 
        { 5, 5, 5, 5, 5 } };

    static final int rows = matrix.length;
    private static int results[]=new int[rows];


    static int threadId=0;
    private static class Summer extends Thread
    {
        int row;

        CyclicBarrier barrier;

        Summer(CyclicBarrier barrier, int row)
        {
            this.barrier = barrier;
            this.row = row;
        }

        public void run()
        {
            int columns = matrix[row].length;
            int sum = 0;
            for (int i = 0; i < columns; i++)
            {
                sum += matrix[row][i];
            }
            results[row] = sum;
            System.out.println("Results for row " + row + " are : " + sum);
            // wait for the others 
            // Try commenting the below block, and watch what happens. 
            try
            {
                int w = barrier.await();
                if(w==0)
                {
                    System.out.println("merging now !");
                    int fullSum = 0;
                    for (int i = 0; i < rows; i++)
                    {

                        fullSum += results[i];
                    }
                    System.out.println("Results are: " + fullSum);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[])
    {
        /*
         * public CyclicBarrier(int parties,Runnable barrierAction)
         * Creates a new CyclicBarrier that will trip when the given number
         * of parties (threads) are waiting upon it, and which will execute 
         * the merger task when the barrier is tripped, performed 
         * by the last thread entering the barrier.
         */
        CyclicBarrier barrier = new CyclicBarrier(rows );
        for (int i = 0; i < rows; i++)
        {
            System.out.println("Creating summer " + i);
            new Summer(barrier, i).start();

        }
        System.out.println("Waiting...");
    }
}