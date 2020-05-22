...
  static boolean running = false;

  public static void main(String[] args) throws Exception {
    playBow();
    while(running) {
      Thread.sleep(200);
    }
  }
  ...
  @Override
  public void update(LineEvent le) {
    LineEvent.Type type = le.getType();
    if (type == LineEvent.Type.OPEN) {
      running = true;
      System.out.println("OPEN");
    } else if (type == LineEvent.Type.CLOSE) {
      System.out.println("CLOSE");
    } else if (type == LineEvent.Type.START) {
      System.out.println("START");
      playingDialog.setVisible(true);
    } else if (type == LineEvent.Type.STOP) {
      System.out.println("STOP");
      playingDialog.setVisible(false);
      clip.close();
      running = false;
    }
  }