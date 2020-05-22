//The data.getData() below refers to the uri you get in onActivityResult
if (isGoogleDrive(data.getData())) {
    DownloadAsyncTask asyntask = new DownloadAsyncTask(data.getData(), this);
    asyntask.execute();
    asyntask.callback = this;
}