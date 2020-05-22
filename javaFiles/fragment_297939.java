public class RenderThread extends Thread {
  private boolean running;
  private final static int MAX_FPS = 30;    
  private final static int FRAME_PERIOD = 1000 / MAX_FPS;   

  @Override
  public void run() {
    long beginTime;
    long timeDiff;
    int sleepTime;

    sleepTime = 0;

    while (running) {
        beginTime = System.currentTimeMillis();

        //RENDER

        // How long did the render take
        timeDiff = System.currentTimeMillis() - beginTime;
        // calculate sleep time
        sleepTime = (int)(FRAME_PERIOD - timeDiff);

        if (sleepTime > 0) {
            try {
                Thread.sleep(sleepTime);    
            } catch (InterruptedException e) {}
        }
     }
   }
}