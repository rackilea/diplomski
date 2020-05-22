Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate( new Runnable()
  {

     @Override
     public void run()
     {
        // call your method here

     }
  }, 0, 1, TimeUnit.MINUTES );