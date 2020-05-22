public static void main(String args[]) {

  final Timer timer = new Timer(1000, new ActionListener() {
    int tick = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Success" + ++tick);
      if (tick > 4) {
        ((Timer) e.getSource()).stop();
      }
    }
  });

  timer.setInitialDelay(0);
  System.out.format("About to schedule task.%n");
  // timer.start(); Or here
  System.out.format("Task scheduled.%n");

  java.awt.EventQueue.invokeLater(new Runnable() {

    public void run() {
      new NewJFrame().setVisible(true); // previously new Test().setVisible(true);
      timer.start();
    }
  });
}