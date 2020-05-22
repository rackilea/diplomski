public long runTime(algorithm alg, int[] array, int trials)
{

    long initialTime = System.nanoTime();

    for(int i = 0; i < trials; i++)
    {
        alg.runAlgorithm(array); 
    }

    return ((System.nanoTime() - initialTime) / (long) trials);
}