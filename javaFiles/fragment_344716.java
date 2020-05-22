exec.shutdown();

    // waiting for executors to finish their jobs
    while (!exec.awaitTermination(50, TimeUnit.MILLISECONDS));

    // perform clean up work