new Timer().schedule(new TimerTask(){
  @Override
  public void run(){
      new connectTaskMain().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
  }
}, 1000);