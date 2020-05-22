// declare the dialog as a member field of your activity
ProgressDialog mProgressDialog;

// instantiate it within the onCreate method
mProgressDialog = new ProgressDialog(YourActivity.this);
mProgressDialog.setMessage("A message");
mProgressDialog.setIndeterminate(true);
mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
final DownloadTask downloadTask = new DownloadTask(YourActivity.this);
downloadTask.execute("the url to the file you want to download");

mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

    @Override
    public void onCancel(DialogInterface dialog) {
        downloadTask.cancel(true); //cancel the task
    }
});