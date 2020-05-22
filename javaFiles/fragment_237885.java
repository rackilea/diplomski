leftFireButton.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch(motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //TODO FIRE BULLET....
                    bulletController.addBullet(new Bullet((ship.getX() + ship.getWidth()/2) - 15, ship.getY() + ship.getHeight()/2, getApplicationContext())); //<--NEW CODE
                    leftFireButton.setBackgroundResource(R.drawable.red_button_pressed);
                    soundPool.play(soundID,1.0f,0.5f,1,0,1.0f);
                    return true;
                case MotionEvent.ACTION_UP:
                    leftFireButton.setBackgroundResource(R.drawable.red_button);
                    //widgets.removeView(laser);
                    return true;
            }

            return false;
        }
    });
    rightFireButton.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch(motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //TODO FIRE BULLET
                    bulletController.addBullet(new Bullet((ship.getX() + ship.getWidth()/2) - 15, ship.getY() + ship.getHeight()/2, getApplicationContext())); //<--- NEW CODE


                    rightFireButton.setBackgroundResource(R.drawable.red_button_pressed);
                    soundPool.play(soundID,1.0f,0.5f,1,0,1.0f);
                    return true;
                case MotionEvent.ACTION_UP:
                    rightFireButton.setBackgroundResource(R.drawable.red_button);
                    //widgets.removeView(laser);

                    return true;
            }

            return false;
        }
    });