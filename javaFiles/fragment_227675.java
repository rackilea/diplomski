Override
public void onCompletion(MediaPlayer mp) {
    didFinishFirst = true;
    if(didFinishFirst) {

        Uri songUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.two);

        mp = MediaPlayer.create(getApplicationContext(), songUri);
        mp.start();
        mState = STATE_INITIALIZED;
        didFinishSecond = true;
        mp.setOnCompletionListener(this);
        // ^^^^^^^^^^^^^^^^^^^^^^
    } else if(didFinishSecond){
        Uri songUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.three);

        mp = MediaPlayer.create(getApplicationContext(), songUri);
        mp.start();
        mState = STATE_INITIALIZED;
        didFinishThird = true;
        mp.setOnCompletionListener(this);
        // ^^^^^^^^^^^^^^^^^^^^^^
    }
    mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

        @Override
        public void onPrepared(MediaPlayer mp) {
            // No need
        }
    });
}