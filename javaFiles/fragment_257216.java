File mediaStorageDir = context.getFilesDir();

    if (!mediaStorageDir.exists()) {
        if (!mediaStorageDir.mkdirs()) {
            Log.d("Fade", "failed to create directory");
            return null;
        }
    }
    // Create a media file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
            .format(new Date());

    File mediaFile=new File(mediaStorageDir.getPath()+File.separator
                + "IMG_" + timeStamp + ".JPG");

    return mediaFile;
}