@Override
protected BigInteger compute() {
    if(!fibCache.containsKey(n)){

        FibonacciTask worker1 = new FibonacciTask(n-1, fibCache);
        FibonacciTask worker2 = new FibonacciTask(n-2, fibCache);
        worker1.fork(); // fork this work to new thread

        result = worker2.compute().add(worker1.join());

     // ... snip ...
}