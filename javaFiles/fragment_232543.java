// setup the GUI
frame.setVisible(true);
EventQueue.invokeLater(new Runnable() {
    public void run()
    {
      doYourHavyComputation();
    }
  });