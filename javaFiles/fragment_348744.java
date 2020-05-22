void TestForLoop()
{
    time start = GetTime();

    for(int i = 0; i < 1000000000; ++i)
    {
    }

    time elapsed = GetTime() - start;
    time elapsedPerIteration = elapsed / 1000000000;
    printf("Time elapsed for each iteration: %d\n", elapsedPerIteration);
}