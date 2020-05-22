Timer t = new Timer();   
t.scheduleAtFixedRate(
    new TimerTask()
    {
        public void run() {
          Platform.runLater(new Runnable() {
              @Override
              public void run() {
                  for (int id = 0; id < label.length; id++) {
                      label[id].setText(getTimeLeft(id));
                  }
              }
          });
        }
    },
    0,      // run first occurrence immediately
    1000);  // run every seconds