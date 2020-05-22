ActionListener listener = new ActionListener(){
  public void actionPerformed(ActionEvent event){
    checkUser = true;
  }
};
Timer checkUserTimer = new Timer(5000, listener); // the 5 second gap
checkUserTimer.start(); // start the timer.