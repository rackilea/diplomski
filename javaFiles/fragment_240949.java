@Override
    protected void onProgressUpdate(Integer... values) {
        if (values.length>0) {
            //Log.d("Download Activity", "progressUpdate:"+values[0]);
            if (values[0] < 0) {
                this.cancel(true);
                showNetworkErrorDialog();
            } else {
                //size += values[0];
                //Log.d("Download Activity", "download size:"+size);
                //downloadedGoodListSize += values[0];
                //downloadProgressBar.incrementProgressBy(values[0]);
                setCurrentProgress(values[0]);
                downloadProgressBar.setProgress(values[0]);
                double currentProg = downloadProgressBar.getProgress()*1.0/downloadProgressBar.getMax()*100;
                //progressTextView.setText( decimalFormat.format(downloadedGoodListSize*1.0/downloadProgressBar.getMax()*100.0)+"%");
                progressTextView.setText(decimalFormat.format(downloadProgressBar.getProgress()*1.0/downloadProgressBar.getMax()*100)+"%");


                notification.contentView.setProgressBar(R.id.pb, 100, (int)currentProg, false);

                nm.notify(notificationID, notification);

            }
        }
    }

@Override
    protected void onPostExecute(Boolean result) {
        Log.i("Download Activity", "onPostExecute: starting");
        downloadProgressBar.setProgress(downloadProgressBar.getMax());
        progressTextView.setText(100+"%");
        wheelProgressBar.setVisibility(View.GONE);
        downloadingTextView.setText(getFinishedText());

       notification.contentView.setProgressBar(R.id.pb, 100, 100, false);
       nm.notify(notificationID, notification);
       nm.cancelAll();

        Log.i("Download Activity", "onPostExecute: set interface ok");
        finishDialog.show();

    }