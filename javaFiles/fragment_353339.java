someViewLikeLinearLayout.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //put finger on screen
                    return true;
                case MotionEvent.ACTION_UP:
                    //release the finger
                    return true;

            }

        }
    });