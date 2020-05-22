v.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                v.setSelected(arg1.getAction()==MotionEvent.ACTION_DOWN);
                return true;
            }
        });