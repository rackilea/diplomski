JFrame fr = new JFrame();
fr.setResizable(false);
if (!fr.isDisplayable()) {
    // Can only do this when the frame is not visible
    fr.setUndecorated(true);
}
GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
try {
  if (gd.isFullScreenSupported()) {
    gd.setFullScreenWindow(fr);
  } else {
    // Can't run fullscreen, need to bodge around it (setSize to screen size, etc)
  }
  fr.setVisible(true);
  // Your business logic here
} finally {
  gd.setFullScreenWindow(null);
}