public void actionB(){
    synchronized(MyClass.class) {
      Thread thread = new Thread(new Runnable { run() { actionA(); }});
      thread.start();
      thread.join();
    }
}