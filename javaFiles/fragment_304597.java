// Simply delete   synchronized (mLock)

   public void stop() {

    if (mThread != null) {
        mThread.interrupt();
        mThread = null;
    }

    dismiss();
    if (mAudioRecord != null) {
        mAudioRecord.stop();
    }

}