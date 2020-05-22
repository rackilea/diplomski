iv.setOnClickListener(new OnClickListener() {           
                @Override
                public void onClick(View v) {
                    //putyour first activity call.
                }
    }

iv.setOnTouchListener(new OnTouchListener() {
             GestureDetector gestureDetector = new GestureDetector(new MyGestureDetector(context));
         @Override
         public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
         }
});