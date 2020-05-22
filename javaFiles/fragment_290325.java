mFloatingActionButton.setOnTouchListener(new View.OnTouchListener() {
 @Override
 public boolean onTouch(View v, MotionEvent event) {
 if (gestureDetector.onTouchEvent(event)) {
  // code for single tap or onclick

  // pass your intent here
  } else {

  switch(event.getAction()){
  //  code for move and drag

  // handle your MotionEvents here
  }
     return true;
            }
        });