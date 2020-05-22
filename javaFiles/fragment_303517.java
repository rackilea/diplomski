void someFunction(SomeType stuff, SomeType andStuff) {
    ExecutorService exe = Executors.newFixedThreadPool(4);   // 4 can be changed of course
    for (Object object : lotsOfObjects) {
        exe.submit(() -> object.doSomethingThatCanBeDoneInParallel(stuff, andStuff));
    }

    // Following lines are optional, depending if you need to wait until all tasks are finished or not
    exe.shutdown();
    try {
        exe.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }   
}