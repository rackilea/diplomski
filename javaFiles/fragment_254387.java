Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
 new Runnable() {
  @Override
  public void run() {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        changeImage();
        repaint();
       }
    };
  }
}, 0, 5, TimeUnit.SECONDS);