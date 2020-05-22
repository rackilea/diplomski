@Override
public void onAudioFocusChange(int focusChange) {
    switch (focusChange) {
        case AudioManager.AUDIOFOCUS_GAIN:
            Log.d(TAG, "AUDIOFOCUS_GAIN");
            mHasAudioFocus = requestAudioFocus();
            break;
        case AudioManager.AUDIOFOCUS_LOSS:
            Log.d(TAG, "AUDIOFOCUS_LOSS");
            abandonAudioFocus();
            break;
        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
            Log.d(TAG, "AUDIOFOCUS_LOSS_TRANSIENT");
            abandonAudioFocus();
            startAudioFocusCountdownTimer(); 
            break;
        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
            Log.d(TAG, "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
            abandonAudioFocus();
            startAudioFocusCountdownTimer(); 
            break;
        default:
            Log.d(TAG, "Unrecognized audiofocus change");
    }
}

private void startAudioFocusCountdownTimer() {
     new CountDownTimer(2000, 2000) {
        public void onTick(long millisUntilFinished) {
            // do nothing
        }
        public void onFinish() {
            mHasAudioFocus = requestAudioFocus();
            if (!mHasAudioFocus)
                startAudioFocusCountdownTimer();
        }
    }.start();
}