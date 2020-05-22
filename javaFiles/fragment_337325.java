// start executing task
taskCounter.incrementAndGet();
// execute task
...
// stop executing task
if (taskCounter.decrementAndGet() == 0) {
    condition.signal();
}