Executor executor = Executors.newFixedThreadPool(5);

// all jobs are submitted sequentially, but only 5 jobs execute concurrently at a time
for(Runnable job : jobs)
{
    executor.execute(job);
}