private void startDialog() {
  final JDialog d = new JDialog(this, "Test", true);
  d.getContentPane().add(new JLabel("Something"));
  d.setBounds(100, 100, 400, 300);
  Thread t = new Thread(new Runnable() {
    public void run() {
      for (int i = 0; i < 50; i++) {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            Point p = d.getLocation();
            d.setLocation(p.x + 10, p.y + 10);
          }
        });
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          // ignore
        }
      }
    }
  });
  t.start();
  d.setVisible(true);
}