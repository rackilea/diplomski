View.OnLongClickListener listener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View view) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // PRESSED
                            return true; // if you want to handle the touch event
                        case MotionEvent.ACTION_UP:
                            // RELEASED
                            return true; // if you want to handle the touch event
                    }
                    return false;
                }
            });
            return true;
        }

    };