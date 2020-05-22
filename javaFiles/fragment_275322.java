for(String x : mList) {
   mExecutor.execute(new Runnable() {    
        @Override
        public void run() {
            //Do Stuff
        }    
   });
 }

 mExecutor.shutdown();
 mExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

 //after all threads finish
 doOtherStuff();