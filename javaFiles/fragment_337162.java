// the timer variable must be a javax.swing.Timer
  // TIMER_DELAY is a constant int and = 35;
  new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        gameLoop();
     }
  }).start();