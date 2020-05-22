Thread t = new Thread(new Runnable(){
  public void run()
  {
    // Here you can use Timer or Thread sleep 1s up to X seconds
    // and on each iteration increment your jProgressBar.
    // TODO: Your code...

    return; // To kill the thread
  }
});

t.start();