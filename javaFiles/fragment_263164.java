Thread mThread = new Thread(new Runnable() {

@Override
public void run() {
    try  {
        //Put your code that you want to run in here(check your connection for example)
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
});

mThread.start