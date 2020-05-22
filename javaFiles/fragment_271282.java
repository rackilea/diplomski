mProgressStatus = 0;
progressThread = new Thread(new Runnable() {             
    public void run() {                 
        while (mProgressStatus < 100) {                                          
            // Update the progress bar                     
            mHandler.post(new Runnable() {                         
                public void run() {                             
                    progressBar.setProgress(mProgressStatus);                         
                }                     
            });
            mProgressStatus ++;
            android.os.SystemClock.sleep(1000); // Thread.sleep() doesn't guarantee 1000 msec sleep, it can be interrupted before               
        }             
    }         
});

progressThread.start();