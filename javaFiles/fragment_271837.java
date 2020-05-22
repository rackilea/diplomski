public class MyWebServer {

  public void foo() throws IOException {
    while (true) {
      //block here until a connection request is made
      ServerSocket socket = new ServerSocket();

      try {
        final Object locker = new Object();
        //create a new HTTPRequest object for every file request
        MyRequest request = new MyRequest(socket);
        request.addResumeListener(new ResumeListener() {
          public void resume() {
            locker.notify();
          }
        });
        synchronized(locker){

          //create a new thread for each request
          Thread thread = new Thread(request);

          //start() the thread - not run()
          thread.start();

          //this thread will block until the MyRequest run method calls resume
          locker.wait();
        }  
      } catch (Exception e) {
      }

    }
  }
}

public interface ResumeListener {
  public void resume();
}

public class MyRequest implements Runnable{
  private ResumeListener resumeListener;

  public MyRequest(ServerSocket socket) {
  }

  public void run() {
    // do something
    resumeListener.resume(); //notify server to continue accepting next request
  }

  public void addResumeListener(ResumeListener rl) {
    this.resumeListener = rl;
  }
}