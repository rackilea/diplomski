int delay = 1000; //milliseconds
  ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          //...Perform a task...
      }
  };
  new Timer(delay, taskPerformer).start();