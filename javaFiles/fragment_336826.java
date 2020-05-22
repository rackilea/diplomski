@Override
    protected void onPause() {
        if(mPlayer!=null || mPlayer.isPlaying()){
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = null;
        super.onPause();
    }