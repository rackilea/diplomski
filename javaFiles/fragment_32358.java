protected void showDelayedImages() {

    mImageView.setImageResource(resId1);

    Timer timer = new Timer();
    timer.schedule( new MyTimerTask(), 1000 );
}

private class MyTimerTask extends TimerTask {
    @Override
    public void run() {

        runOnUiThread( new Runnable() {

            @Override
            public void run() {

                mImageView.setImageResource(resId2);
            }
        } ); 
    }
}