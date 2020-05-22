...

 frame.addWindowListener(new WindowAdapter() {
    @Override
  public void windowClosing(WindowEvent evt) {
    frame.setVisible(false);
  }
});