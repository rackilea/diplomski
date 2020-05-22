private MediaPlayer bVideoViewMP;


bVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
    @Override
    public void onPrepared(MediaPlayer mp) {
        // Fetch a reference
        bVideoViewMP = mp;
    }
});

audioToggle.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent e) {

        bVideoView.start();

        switch(e.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                bVideoViewMP.setVolume(0.75f, 0.75f);
                break;
            case MotionEvent.ACTION_UP:
                bVideoViewMP.setVolume(0, 0);
                break;
        }
        return true;
    }
}