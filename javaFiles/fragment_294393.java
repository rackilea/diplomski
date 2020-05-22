@Override
protected void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.activity_splash);

    mProgress = (ProgressBar) findViewById(R.id.progressBar);

    new Thread(new Runnable() {
        public void run() {
            while (mProgressStatus < 100) { // Show progress till its 100
                //for example your downloading something, everytime you hit the while loop ,you'll update the mProgressStatus to current progress.
                //I need to download file of size 10mb
                //every time while loops execute , you calcluate size downloaded say 1mb i.e.. 1mb of 10mb means 10% progressed so set mProgressStatus to 10
                int percentageOfFileDownloaded = (downloadedfileSize/TotalFileSize) * 100; //Just for example
                mProgressStatus = percentageOfFileDownloaded;
                  //At one moment your entire file will be downloaded (10mb of 10mb) so update mProgressStatus to 100; it will break while loop.
                // Update the progress bar 
                mHandler.post(new Runnable() {
                    public void run() {
                        mProgress.setProgress(mProgressStatus);
                    }
                });
            }
        }
    }).start();

}
}