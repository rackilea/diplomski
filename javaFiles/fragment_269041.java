class B()
   {
   private final Executor threadPool = Executors.newFixedThreadPool(1);
   private boolean taskSubmmitted = false;
   public static B getInstance()
   {
       return B singleton object;
   }

   public synchronized void method1()
   {
     if(taskSubmitted)
        return;
     myRunnable = new Runnable(){
       public void run(){ 
              do some stuff.....
       }};
     threadPool.submit(myRunnable);
     taskSubmitted = true;
   }