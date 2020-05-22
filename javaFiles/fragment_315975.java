button.setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                //start recording
            }
            else if(arg1.getAction() == MotionEvent.ACTION_UP) {
                //stop recording
            }
            return true;
        }
    });