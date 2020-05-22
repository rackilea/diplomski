class MyThread extends Thread {

  private JFrame frame;
  //-- getters and setters for frame

  public void run() {
    Thread.sleep(1000); //close the frame after 1 second.
    frame.close();
  }

}