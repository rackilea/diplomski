private static volatile HashMap<Integer, Integer> occurenceMap= new HashMap<Integer, Integer>();


    public synchronized static int getNumOccurrences(final Integer number) {
        // C: here's a container to use inside the runnable
        // C: must be final to use inside the runnable below
        final AtomicInteger result = new AtomicInteger(0);
        try { 
        // C: keep a rerefence to the thread we create
        Thread thread = new Thread() {

            public void run() {

                Integer occurrences = occurenceMap.get(number); 
                if ( occurrences != null && occurrences > 0 ) {
                    result.set(occurences); // C: we found what we're looking for
                    return; // C: so get out of the run method
                } else {
                    CountDownLatch latch = new CountDownLatch(1); 
                    pendingList.put(number, latch);
                    latch.await();  
                    // elsewhere in the code, I call countdown when I get a hit
                    pendingList.remove(number);

                    // once we've counted down, I would like to return the value
                    result.set(1); // C: I'm not sure what you want to return here
                    return; // C: but I'm sure you can figure that out...
                 }
               }
           });
           thread.start(); // C: now start the thread
           thread.join(); // C: join the thread, waiting for it to finish
       } catch ( Throwable t ) { }
       return result.get(); // C: now return the int from the container
    }