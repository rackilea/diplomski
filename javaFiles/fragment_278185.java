editText.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction())
                    Toast.makeText(getApplicationContext(), "onTouch: Up", Toast.LENGTH_SHORT).show();
                return false;
            }

    });