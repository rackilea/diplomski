int someNumberOfMillisToSleep = //some number;
    ...

    while (!future.isDone()) {
        Thread.sleep(someNumberOfMillisToSleep );
    }

    /*now that future.isDone() returned true, 
you can get the result and go on with on with you logic
   */ 
    int res = future.get();

    //some computation here