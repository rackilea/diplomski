import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayReordering
{
    public static void main(String[] args)
    {
        basicTest();
        performanceTest();
    }

    private static void basicTest()
    {
        int[] vectorUsedForSorting = new int[] { 1,0,2,6,3,4,5 };
        int[] vectorToBeSorted = new int[] {1,2,3,4,5,6,7};      
        int[] sortedVectorLinear = new int[vectorToBeSorted.length];
        int[] sortedVectorParallel = new int[vectorToBeSorted.length];

        sortLinear(vectorUsedForSorting, vectorToBeSorted, sortedVectorLinear);
        sortParallel(vectorUsedForSorting, vectorToBeSorted, sortedVectorParallel);

        System.out.println("Result Linear   "+Arrays.toString(sortedVectorLinear));
        System.out.println("Result Parallel "+Arrays.toString(sortedVectorParallel));
    }

    private static void performanceTest()
    {
        for (int n=1000000; n<=50000000; n*=2)
        {
            System.out.println("Run with "+n+" elements");

            System.out.println("Creating input data");
            int vectorUsedForSorting[] = createVectorUsedForSorting(n);
            int vectorToBeSorted[] = new int[n];
            for (int i=0; i<n; i++)
            {
                vectorToBeSorted[i] = i;
            }
            int[] sortedVectorLinear = new int[vectorToBeSorted.length];
            int[] sortedVectorParallel = new int[vectorToBeSorted.length];

            long before = 0;
            long after = 0;

            System.out.println("Running linear");
            before = System.nanoTime();
            sortLinear(vectorUsedForSorting, vectorToBeSorted, sortedVectorLinear);
            after = System.nanoTime();
            System.out.println("Duration linear   "+(after-before)/1e6+" ms");

            System.out.println("Running parallel");
            before = System.nanoTime();
            sortParallel(vectorUsedForSorting, vectorToBeSorted, sortedVectorParallel);
            after = System.nanoTime();
            System.out.println("Duration parallel "+(after-before)/1e6+" ms");

            //System.out.println("Result Linear   "+Arrays.toString(sortedVectorLinear));
            //System.out.println("Result Parallel "+Arrays.toString(sortedVectorParallel));
            System.out.println("Passed linear?   "+
                Arrays.equals(vectorUsedForSorting, sortedVectorLinear));
            System.out.println("Passed parallel? "+
                Arrays.equals(vectorUsedForSorting, sortedVectorParallel));
        }
    }

    private static int[] createVectorUsedForSorting(int n)
    {
        // Not very elegant, just for a quick test...
        List<Integer> indices = new ArrayList<Integer>();
        for (int i=0; i<n; i++)
        {
            indices.add(i);
        }
        Collections.shuffle(indices);
        int vectorUsedForSorting[] = new int[n];
        for (int i=0; i<n; i++)
        {
            vectorUsedForSorting[i] = indices.get(i);
        }
        return vectorUsedForSorting;
    }

    private static void sortLinear(
        int vectorUsedForSorting[], int vectorToBeSorted[], 
        int sortedVector[])
    {
        sortLinear(vectorUsedForSorting, vectorToBeSorted, 
            sortedVector, 0, vectorToBeSorted.length);
    }

    static void sortParallel(
        final int vectorUsedForSorting[], final int vectorToBeSorted[], 
        final int sortedVector[])
    {
        int numProcessors = Runtime.getRuntime().availableProcessors();
        int chunkSize = (int)Math.ceil((double)vectorToBeSorted.length / numProcessors);
        List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
        ExecutorService executor = Executors.newFixedThreadPool(numProcessors);
        for (int i=0; i<numProcessors; i++)
        {
            final int min = i * chunkSize;
            final int max = Math.min(vectorToBeSorted.length, min + chunkSize);
            Runnable task = new Runnable()
            {
                @Override
                public void run()
                {
                    sortLinear(vectorUsedForSorting, vectorToBeSorted, 
                        sortedVector, min, max);
                }
            };
            tasks.add(Executors.callable(task));
        }
        try
        {
            executor.invokeAll(tasks);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        executor.shutdown();
    }

    private static void sortLinear(
        int vectorUsedForSorting[], int vectorToBeSorted[], 
        int sortedVector[], int min, int max)
    {
        for (int i = min; i < max; i++)
        {
            sortedVector[i] = vectorToBeSorted[vectorUsedForSorting[i]];
        }          
    }

}