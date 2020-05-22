int numberOfParties = 5;
 AtomicInteger numberOfJobsToExecute = new AtomicInteger(1000);
 ExecutorService pool = Executors.newFixedThreadPool(numberOfParties );
 for(int i =0; i < numberOfParties; i++){
     pool.submit(new Runnable(){
        public void run(){
            while(numberOfJobsToExecute.decrementAndGet() >= 0){
                makeJobs(1).get(0).run();
            }
        }
     });
 }