public class DownloadPDFTask extends AsyncTask<String, Void, Void> {

    @Override
    protected synchronized void onPreExecute() {
        String mDownloadDIR = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        super.onPreExecute();
        File mDirectory = new File(mDownloadDIR);
        if (mDirectory.isDirectory()) {
            String[] children = mDirectory.list();
            for (String child : children) {
                if (child.contains(".pdf")) {
                    new File(mDirectory, child).delete();
                }
            }
        }
    }

    @Override
    private void downloadFilePDF(String url) {
        DownloadManager mDownloadManager = (DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri mUri = Uri.parse(url);
        DownloadManager.Request mReq = new DownloadManager.Request(mUri);
        mReq.setTitle("Develop Test");
        mReq.setDescription("PDF downloading....");
        mReq.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        mReq.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "temp.pdf");
        mReq.setMimeType("application/pdf");
        mDownloadManager.enqueue(mReq);
        return null;
    }

    @Override
    protected synchronized void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        NotificationManager mNotificationManager = (NotificationManager) BaseApplication.getAppContext().getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancelAll();
    }
}