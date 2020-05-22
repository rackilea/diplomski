List<Future<?>> futures = new ArrayList<Future<?>>();
ExecutorService exec = Executors.newFixedThreadPool(5);

// Instead of using exec.execute() use exec.submit()
// because it returns a monitorable future
while((item = stack.pollFirst()) != null){
    Runnable worker = new Solider(this, item);
    Future<?> f = exec.submit(worker);
    futures.add(f);
}

// A) Await all runnables to be done (blocking)
for(Future<?> future : futures)
    future.get(); // get will block until the future is done

// B) Check if all runnables are done (non-blocking)
boolean allDone = true;
for(Future<?> future : futures){
    allDone &= future.isDone(); // check if future is done
}