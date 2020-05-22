int waitForPhase = K-1;
ExecutorService e = Executors.newFixedThreadPool(n);
Phaser phaser = new Phaser(n);
for(int i=0; i< n ;i++){
   e.submit(new Runnable(){
       public void run(){
          for(j =0 ;j < waitForPhase ; j++){ 
              //do work
              phaser.arriveAndAwaitAdvance();
              // if you do not want all sub threads to wait for each
              // this can also be phaser.arrive() 
          }
       }
   });
}
phaser.awaitAdvance(waitForPhase);