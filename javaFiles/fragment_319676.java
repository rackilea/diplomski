public AudioRecord(int audioSource, int sampleRateInHz, int channelConfig, int audioFormat, 
            int bufferSizeInBytes)
    throws IllegalArgumentException {   
        mState = STATE_UNINITIALIZED;
        mRecordingState = RECORDSTATE_STOPPED;

        ... //parameter checks

        // native initialization
        //update native initialization when information about hardware init failure
        //due to capture device already open is available.
        int initResult = native_setup( new WeakReference<AudioRecord>(this), 
                mRecordSource, mSampleRate, mChannels, mAudioFormat, mNativeBufferSizeInBytes);
        if (initResult != SUCCESS) {
            loge("Error code "+initResult+" when initializing native AudioRecord object.");
            return; // with mState == STATE_UNINITIALIZED
        }

        mState = STATE_INITIALIZED;
    }