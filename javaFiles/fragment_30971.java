// declare the work queue
   private final Executor workQueue = Executors.newCachedThreadPool(); 




   // when you want to eat, schedule a bunch of 'eating' jobs
       public void eat(final Food item){
          for (final AbstractObserver o: list) {
             workQueue.execute(new Runnable() {

                @Override
                public void run() {
                   o.eatFood(item); // runs in background thread
                }
             });
          }
       }