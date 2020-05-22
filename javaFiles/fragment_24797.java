public class B implements Runnable {
      private int myParam;

      public void setMyParam(int i) {
        myParam = i;
      }

    public void run() {
      execute(myParam)
    }

    private void execute(int i) {
      ...
    }
  }