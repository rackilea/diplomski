@Override
    public void onClick(View v) {
        mRecordingState = "Playing";
        switchButtonVisibility();

        mBtn_Play.post(new Runnable() {
            @Override
            public void run() {
                for (final int sound : mListRecordedSounds ) {
                    // play the sound here
                    ...
                }
            }
        });
    }