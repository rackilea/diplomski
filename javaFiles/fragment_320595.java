Executor ex = Executors.newCachedThreadPool();
for(int i = 0; i < 20; i++){
   final Creature c = new Creature(this);
   ex.execute(new Runnable(){
      public void run(){
         c.execute();  
      }
   });   
}