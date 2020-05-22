int delay = 1000; //milliseconds
  ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          if(blackTurn)
             black--;
          else if(whiteTurn)
             white--;
      }
  };
  new Timer(delay, taskPerformer).start();