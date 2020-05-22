SwingUtilities.invokeLater(new Runnable() {
  public void run() {
    myTextArea.append(myLine);
    myTextArea.repaint();
  }
});