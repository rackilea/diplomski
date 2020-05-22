yourviewpager.setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                recyclerview.requestDisallowInterceptTouchEvent(true);
//or you can apply on ScrollView also
                //scrollview.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });