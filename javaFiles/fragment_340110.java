@Override
        public void onUserInteraction() {
            super.onUserInteraction();
 if (onOffButton.isChecked()) {
          readPreferences();
          micInput.setSampleRate(mSampleRate);
          micInput.setAudioSource(mAudioSource);
          micInput.start();
        } else {
          micInput.stop();
        }