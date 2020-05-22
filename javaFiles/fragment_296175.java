int streamId = -1;
C5.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                // PRESSED
                streamId = sp.play(SC5, 1, 1, 0, 0, 1);
                return true; 


            case MotionEvent.ACTION_UP:
                // RELEASED
                sp.pause(streamId);

                return true; 
        }
        return false;
    }
});