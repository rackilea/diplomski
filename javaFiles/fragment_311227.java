private static int aux = 0;
private AudioManager mAudioManager;

audioToggle.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent e) {

        bVideoView.start();

        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        switch(e.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 50, 0);
                break;
            case MotionEvent.ACTION_UP:
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
                break;
        }
        return true;
    }
}