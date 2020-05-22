HashSet<Future> futures = new HashSet<>();
int concurrentTasks = 1000;

for (int ii=0; ii<100000000; ii++) {
    while(concurrentTasks-- > 0 && ii<100000000) {
        concurrentTasks.add(executor.submit(new Task(ii)));
    }
    Iterator<Future> it = concurrentTasks.iterator();
    while(it.hasNext()) {
        Future task = it.next();
        if (task.isDone()) {
            concurrentTasks++;
            it.remove();
        }
    }
}