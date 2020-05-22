private static final String APP_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyAppFolderInStorage/";

private void install() {
    File file = new File(APP_DIR + fileName);

    if (file.exists()) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String type = "application/vnd.android.package-archive";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri downloadedApk = FileProvider.getUriForFile(getContext(), "ir.greencode", file);
            intent.setDataAndType(downloadedApk, type);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            intent.setDataAndType(Uri.fromFile(file), type);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }

        getContext().startActivity(intent);
    } else {
        Toast.makeText(getContext(), "ّFile not found!", Toast.LENGTH_SHORT).show();
    }
}