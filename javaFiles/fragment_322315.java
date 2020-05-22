AtomicInteger value = new AtomicInteger(0);
while (true) {
  SwingUtilities.invokeLater(new Runnable() {
    public void run() {
      pbCompleteness.setValue(value.get());
    }
  });

  // Do some work and update value.
}