Timer t = new Timer();
    t.scheduleAtFixedRate(new TimerTask() {

                              @Override
                              public void run() {
                                  rd = new Random();
                                  final int rdcolor = Color.argb(255, rd.nextInt(256), rd.nextInt(256), rd.nextInt(256));
                                  runOnUiThread(new Runnable() {
                                      @Override
                                      public void run() {
                                          txtLucky.setTextColor(rdcolor);
                                      }
                                  });
                              }
                          },
            //Set how long before to start calling the TimerTask (in milliseconds)
            0,
            //Set the amount of time between each execution (in milliseconds)
            2000);