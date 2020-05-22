PipedInputStream in = new PipedInputStream();
  PipedOutputStream out = new PipedOutputStream(in);
  new Thread(
    new Runnable(){
      public void run(){
        class1.putDataOnOutputStream(out);
      }
    }
  ).start();
  class2.processDataFromInputStream(in);