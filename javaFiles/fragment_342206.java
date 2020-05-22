renderVideoIntoMp4(myVideoURL, new GlInvertFilter()); // add the Filter you want


void renderVideoIntoMp4(String filePath, GlFilter filter) {
    tempVideoPath = getVideoFilePath();
            //Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/temp_video.mp4";

    new Mp4Composer(filePath, tempVideoPath)
            // .rotation(Rotation.ROTATION_270)
            //.size(720, 1280)
            .fillMode(FillMode.PRESERVE_ASPECT_FIT)
            .filter(filter)
            .mute(false)
            .flipHorizontal(false)
            .flipVertical(false)
            .listener(new Mp4Composer.Listener() {
                @Override
                public void onProgress(double progress) {
                    Log.i(Configurations.TAG, "SAVING PROGRESS: " + progress);
                }

                @Override
                public void onCompleted() {
                    Log.i(Configurations.TAG, "onCompleted()");
                    exportMp4ToGallery(getApplicationContext(), tempVideoPath);
                    Log.i(Configurations.TAG, "SAVED VIDEO PATH: " + tempVideoPath);

                    File file = new File(tempVideoPath);
                    file.delete();
                }

                @Override
                public void onCanceled() {

                }

                @Override
                public void onFailed(Exception e) {
                    Log.i(Configurations.TAG, "onFailed(): " + e.getMessage());
                }
            })
            .start();
}

public static void exportMp4ToGallery(Context context, String filePath) {
    final ContentValues values = new ContentValues(2);
    values.put(MediaStore.Video.Media.MIME_TYPE, "video/mp4");
    values.put(MediaStore.Video.Media.DATA, filePath);
    context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            values);
    context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
            Uri.parse("file://" + filePath)));
}

public File getAndroidMoviesFolder() {
    return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
}

public String getVideoFilePath() {
    return getAndroidMoviesFolder().getAbsolutePath() + "/temp_video.mp4";
}