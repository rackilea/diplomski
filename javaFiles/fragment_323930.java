ed.setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ((EditText)v).setText("");
            return false;
        }
    });