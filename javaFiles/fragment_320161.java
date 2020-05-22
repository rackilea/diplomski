ExecutorService e = Executors.newFixedThreadPool(1);

private void submitWork(){
   e.submit(new Runnable(){
       public void run(){
          ///do work with devices and get its data            
          e.submit(this);
       }
   });
}