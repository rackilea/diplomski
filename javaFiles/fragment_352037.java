policeSounds.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

        if (policeSound == null) {
            policeSound = MediaPlayer.create(getApplicationContext(), R.raw.police);
        }

        int eventPadTouch = event.getAction();

        switch (eventPadTouch) {

            case MotionEvent.ACTION_DOWN:
                // start playing sound , in your case:
                policeSound.start();
                return true;


            case MotionEvent.ACTION_UP:
                // stop playing sound , in your case:
                policeSound.pause();
                return true;

        }
        return false;
    }
}