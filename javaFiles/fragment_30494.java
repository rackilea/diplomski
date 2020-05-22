private void storeImage(File image) {
    File pictureFile = getOutputMediaFile();
    if (pictureFile == null) {
        return;
    }
    try {
        FileOutputStream output = new FileOutputStream(pictureFile);
        FileInputStream input = new FileInputStream(image);

        FileChannel inputChannel = input.getChannel();
        FileChannel outputChannel = output.getChannel();

        inputChannel.transferTo(0, inputChannel.size(), outputChannel);
        output.close();
        input.close();
        Toast.makeText(MainActivity.this, "Image Downloaded", Toast.LENGTH_SHORT).show();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private File getOutputMediaFile() {
    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/Christmas"); /*getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/Christmas/c");*/
    if (!mediaStorageDir.exists()) {
        if (!mediaStorageDir.mkdirs())
            return null;
    }

    File mediaFile;
    mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_MERRY_CHRISTMAS_"+Calendar.getInstance().getTimeInMillis() +".gif");
    return mediaFile;
}