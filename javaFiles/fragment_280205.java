t1.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch ( event.getAction() ) {
                case MotionEvent.ACTION_DOWN:
                    t1.setTextColor(Color.RED); // pressed state
                 break;

                case MotionEvent.ACTION_UP:
                    t1.setTextColor(Color.WHITE); // Released state
                 break;
            }
            return true;
        }
    });