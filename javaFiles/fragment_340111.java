@Override
      public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    if (onOffButton.isChecked()) {
                  readPreferences();
                  micInput.setSampleRate(mSampleRate);
                  micInput.setAudioSource(mAudioSource);
                  micInput.start();
                } else {
                  micInput.stop();
    }