void TestFileOpenPerformance()
{
    FILE* file = NULL;
    time start = GetTime();

    for(int i = 0; i < 1000000000; ++i)
    {
        file = fopen("testfile.dat");
        fclose(file);
    }

    time elapsed = GetTime() - start;
    time elapsedPerIteration = elapsed / 1000000000;
    printf("Time elapsed for each file open: %d\n", elapsedPerIteration);
}