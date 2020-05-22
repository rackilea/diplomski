BroadcastReceiver onComplete = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        // do something
    }
};

registerReceiver(onComplete, new IntentFilter(
        DownloadManager.ACTION_DOWNLOAD_COMPLETE));