imageButton.setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){

                mp = MediaPlayer.create(MyActivity.this,R.raw.sound);
                mp.start();

                return true;
            }

           else  if(event.getAction() == MotionEvent.ACTION_UP){
                  mp.stop();
                  mp.release();
            return true;
        }

            return false;
        }
    });