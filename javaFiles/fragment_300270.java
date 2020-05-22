@Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != disposableLiveTracking ) {
            disposableLiveTracking .dispose();
        }
    }