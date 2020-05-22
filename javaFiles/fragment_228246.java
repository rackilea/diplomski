capstone.setOnTouchListener(new HandleTouch());
    }   

 private class HandleTouch implements  View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Button btn = (Button) v;
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                btn.setBackgroundResource(R.color.btnClick);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                btn.setBackgroundResource(R.color.btBackground);
            }
            return false;
        }
    }