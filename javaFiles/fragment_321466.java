public void saveScreenshotOnDisk (final View view, final Context context, final String folder, final String title, final String description) {

    final String state = Environment.getExternalStorageState();
    if (state.equals(Environment.MEDIA_MOUNTED)) {
        final Bitmap screenshot = screenShot(view, context);
        final File folderPath = new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + folder + File.separatorChar + "" + "s");
        if (!folderPath.exists()) {
            folderPath.mkdirs();
        }

        final String imagePath = folderPath.getAbsolutePath() + File.separatorChar + "Receipt" + "_" + System.currentTimeMillis() + ".png";
        OutputStream fout = null;
        File imageFile = new File(imagePath);
        try {
            fout = new FileOutputStream(imageFile);
            screenshot.compress(Bitmap.CompressFormat.JPEG, 90, fout);
            MediaStore.Images.Media.insertImage(context.getContentResolver(), screenshot, title, description);

            Toast.makeText(context, "Verifique a pasta " + folder + " .", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            BBLog.w(TAG + ".saveScreenshotOnDisk", e.getMessage());
        }finally{
            try {
                if(fout != null){
                    fout.flush();
                    fout.close();
                }
            } catch (Exception e2) {}
        }
    }
}

public static Bitmap screenShot(final View view, final Context context) {
    view.setBackgroundColor(Color.WHITE);

    Bitmap capture = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(capture);
    view.draw(c);

    view.setBackgroundColor(Color.TRANSPARENT);

    shootSound(context);

    return capture;
}