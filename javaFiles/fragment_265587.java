File toInstall = new File(url);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        File newFile = new File(new File(Environment.getExternalStorageDirectory(), "apps"), getImageNameByUrl(appUrl));
        Uri apkUri = getUriForFile(context, BuildConfig.APPLICATION_ID+".provider", newFile);
        Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
        intent.setData(apkUri);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(intent);
    } else {
        Uri apkUri = Uri.fromFile(toInstall);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }