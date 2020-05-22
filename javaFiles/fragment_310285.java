public void run() {
        final DisplayJFrame df = new DisplayJFrame();
        df.setVisible(true);
        final TestObject to = new TestObject();
        df.setTO(to);

        int timerDelay = 100;
        final int maxCount = 20;
        new Timer(timerDelay, new ActionListener() {
           private int count = 0;

           @Override
           public void actionPerformed(ActionEvent evt) {
              if (count < maxCount) {
                 df.repaint();
                 to.setValue(count);
                 count++;
              } else {
                 ((Timer) evt.getSource()).stop();
              }
           }
        }).start();
        // for (int i = 10; i < 20; i++) {
        // to.setValue(i);
        // try {
        // Thread.sleep(100);
        // } catch (InterruptedException ex) {
        // Logger.getLogger(DisplayJFrame.class.getName()).log(
        // Level.SEVERE, null, ex);
        // }
        //
        // df.draw();
        // }
     }