for(int i = 0; i < n; i++) {
    Worker currThread = new Worker(someArgs);
    workerThreads.add(currThread);
}

// later
for (Worker w : workerThreads) {
    w.start();
}