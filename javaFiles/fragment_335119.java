void addToQueue(SomeObject obj) {
    synchronized (queue) {
        ... put it on my priority queue
        ... do some logging
    }
}