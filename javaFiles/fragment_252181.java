@Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            DownloadManager.Request myRequest = new DownloadManager.Request(Uri.parse(url));
            myRequest.allowScanningByMediaScanner();
            myRequest.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            DownloadManager myManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
            myManager.enqueue(myRequest);
            Toast.makeText(getApplicationContext(), "File is Downloading...", Toast.LENGTH_SHORT).show();
        }
    });