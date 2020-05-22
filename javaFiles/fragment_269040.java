ActionListener timerListener = new ActionListener() {
  public void actionPerformed(ActionEvent evt) {
     // code to be performed every xxx mSec goes here
  }
}
int timerDelay = 3 * 1000; // or whatever length of time needed
Timer timer = new Timer(timerDelay, timerListener);

// later on in the block where you want to start your Timer
timer.start();