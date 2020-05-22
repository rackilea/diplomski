void methodImExecuting() throws InterruptedException {
    // it depends on your implementation, I assume here that you iterate 
    // over a collection for example
    int loopCount = 0;
    for (Foo foo : foos) {
        ++loopCount;
        if (loopCount % 100 == 0) {
            if (Thread.interrupted())
                throw new InterruptedException();
        }
        ...
    }