//Pulled up for access to make canceable .
protected Timer timer;

public void actionPerformed(ActionEvent e) {

  Object source = e.getSource();

  String stringfromDate = tffromDate.getText();
  String stringtoDate = tftoDate.getText();

  if (source == button) {
    //Stop existing one before creating new.
    if(timer != null) {
        timer.cancel();
    }
    //Now make new
    timer = new Timer();

    // auto refresh begins
    int delay = 0; // 0 seconds startup delay
    int period = 7000; // x seconds between refreshes
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override 
        public void run() {

            try {
                getdata(stringfromDate, stringtoDate);// run get data
                                                        // method
            } catch (IOException | BadLocationException ex) {
                Logger.getLogger(JavaApplication63.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }, delay, period);
  }
  if (source == button1) {          
    //NULLCHECK
    if(timer != null) {
        timer.cancel();
    }
    textarea.setText("");
  }
}