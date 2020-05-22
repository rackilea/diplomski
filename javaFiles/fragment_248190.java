public void downloadFile(String uRl) {
    File direct = new File(Environment.getExternalStorageDirectory()
            + "/" + "MyFolder");

    if (!direct.exists()) {
        direct.mkdirs();
    }

    DownloadManager mgr = (DownloadManager) getSystemService(this.DOWNLOAD_SERVICE);

    Uri downloadUri = Uri.parse(uRl);
    DownloadManager.Request request = new DownloadManager.Request(downloadUri);

    request.setAllowedNetworkTypes(
            DownloadManager.Request.NETWORK_WIFI
                    | DownloadManager.Request.NETWORK_MOBILE)
            .setAllowedOverRoaming(false)
            .setTitle("AppNameAsTitle")
            .setDescription("Downloaded using My app")
            .setDestinationInExternalPublicDir("/MyFolder", "filename.jpg")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
    mgr.enqueue(request);
}

@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        downloadFile(url);

    } else {
        Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
    }
}