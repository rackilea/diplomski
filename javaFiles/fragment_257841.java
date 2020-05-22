b.setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                //Change image
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //Restore image
                return true;
            return false;
        }
    });