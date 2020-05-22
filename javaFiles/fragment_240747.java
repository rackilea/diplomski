// this goes somewhere in your class:
  long lastDown;
  long lastDuration;

  ...

  // this goes wherever you setup your button listener:
  button.setOnTouchListener(new OnTouchListener() {
     @Override
     public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
           lastDown = System.currentTimeMillis();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
           lastDuration = System.currentTimeMillis() - lastDown;
        }

        return true;
     }
  });