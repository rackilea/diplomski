public class DownloadReceiver extends BroadcastReceiver {

    private String mDownloadDIR = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
    private Context mContext = BaseApplication.getAppContext();

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
            Log.i("DownloadReceiver", "DownloadCompleted!");
            File retFile = null;
            File directory = new File(mDownloadDIR);
            File[] files = directory.listFiles();
            for (File file : files) {
                Log.i("DownloadReceiver", "Searching file in DOWNLOADS");
                if (file.getName().contains(".pdf")) {
                    Log.i("DownloadReceiver", "File found!");
                    retFile = file;
                    break;
                }
            }

            if (retFile != null) {
                Log.i("DownloadReceiver", "Go to PDF viewing...");
                Intent mGoToPDFView = new Intent(mContext, PDFViewerActivity.class);
                mGoToPDFView.putExtra("FILE", retFile);
                mGoToPDFView.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(mGoToPDFView);
            }

        }
    }
}