button.setText(BTN_CLICKED_TEXT);
  // TIMER_DELAY is some constant int
  Timer myTimer = new Timer(TIMER_DELAY, new ActionListener() {
     private int count = 0;

     @Override
     public void actionPerformed(ActionEvent timerActionEvt) {
        if the count variable is >= some maximum count
          // stop the timer by calling stop on it
          // I'll show you this one since it is a bit complex
          ((Timer)timerActionEvt.getSource()).stop();
          // set the button text to its original state
          // return from this method

        else 
          // randomize pan's color and repaint it
          count++; // increment the counter variable
     }
  });

  myTimer.start();