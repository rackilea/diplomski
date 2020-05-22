public static void main(String...d) {
    ThreadSafe ts=new ThreadSafe();
    Thread t=new Thread(ts);
    Thread t1=new Thread(ts);
    t1.start();
    t.start();
  }