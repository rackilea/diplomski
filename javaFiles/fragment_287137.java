boolean mHasDoubleClicked = false;

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {    

        // Get current time in nano seconds.
        long pressTime = System.currentTimeMillis();


        // If double click...
        if (pressTime - lastPressTime <= DOUBLE_PRESS_INTERVAL) {
            Toast.makeText(getApplicationContext(), "Double Click Event", Toast.LENGTH_SHORT).show();
            mHasDoubleClicked = true;
        }
        else {     // If not double click....
            mHasDoubleClicked = false;
            Handler myHandler = new Handler() {
                 public void handleMessage(Message m) {
                      if (!mHasDoubleClicked) {
                            Toast.makeText(getApplicationContext(), "Single Click Event", Toast.LENGTH_SHORT).show();
                      }
                 }
            };
            Message m = new Message();
            myHandler.sendMessageDelayed(m,DOUBLE_PRESS_INTERVAL);
        }
        // record the last time the menu button was pressed.
        lastPressTime = pressTime;      
        return true;
    }