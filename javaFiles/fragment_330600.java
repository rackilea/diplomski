int threads = 5;
ExecutorService service = Executors.newFixedThreadPool(threads);
LinkedList<Future<?>> futures = new LinkedList<>();

//As long as there are rows to save:
while(moreRowsLeft()){
    //dump another callable onto the queue:
    futures.addLast(service.submit(new RowSavingCallable());

    //if the queue is "full", wait for the next one to finish before
    //reading any more of the file:
    while(futures.size() >= 2*threads) futures.removeFirst().get();
}

//All rows have been submitted but some may still be writing to the DB:
for(Future<?> f : futures) future.get();

//All rows have been saved at this point