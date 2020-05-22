int delay = 3000; //milliseconds
 ActionListener taskPerformer = new ActionListener() {
   public void actionPerformed(ActionEvent evt) {
      System.exit(0);
    }
 };
 new Timer(delay, taskPerformer).start();