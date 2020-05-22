class LongProcess extends Thread {
  public void run() {
    for (int i = 0; i < 10; ++i) {
      SwingUtilities.invokeLater(...);
      Thread.sleep(300);
    }
  }
}

void actionPerformed(ActionEvent e) {
  LongProcess process = new LongProcess();
  process.start();
}