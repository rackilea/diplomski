public void timedMain(Point current, Point wanted) {
      final Point c = current;
      final Point w = wanted;
      ActionListener taskPerformer = new ActionListener(){
          public void actionPerformed(ActionEvent evt){
              System.out.println(w + " " + c);}};
              actiontimer = new Timer(delay, taskPerformer);
              actiontimer.start();}