button.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            //perform your animation when button is touched and held
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
          //perform your animation when button is released
        }
    }
};