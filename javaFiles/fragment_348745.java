void TestForLoop()
{
    int sum = 0;
    time start = GetTime();

    for(int i = 0; i < 1000000000; ++i)
    {
        ++sum;
    }

    time elapsed = GetTime() - start;
    time elapsedPerIteration = elapsed / 1000000000;
    printf("Time elapsed for each iteration: %d\n", elapsedPerIteration);
}