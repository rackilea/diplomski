final SwingWorker worker = ...;

btn_Cancel.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    worker.cancel( true );
  }
});