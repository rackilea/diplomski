@AfterPermissionGranted(PERMISSIONS_REQUEST_CODE)
private void writeFiles() {
    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    if (EasyPermissions.hasPermissions(this, permissions)) {
        try {
            File downloadLocation = new File(Environment.getExternalStorageDirectory() + "/" + "folder" + System.currentTimeMillis());
            downloadLocation.mkdir();

            if (downloadLocation.exists()) {
                Log.i("writeFiles()", downloadLocation.getAbsolutePath());
            }

            File downloadFile = new File(downloadLocation, "file" + System.currentTimeMillis());
            downloadFile.createNewFile();
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
        }
    } else {
        // Do not have permissions, request them now
        EasyPermissions.requestPermissions(this, "Your permission rationale", PERMISSIONS_REQUEST_CODE, permissions);
    }
}