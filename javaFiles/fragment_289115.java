/**
 * Method to take a screenshot programmatically
 */
private void takeScreenshot(){
    GoogleMap.SnapshotReadyCallback callback = new GoogleMap.SnapshotReadyCallback() {
        @Override
        public void onSnapshotReady(Bitmap bitmap) {
            Bitmap b = bitmap;
            String timeStamp = new SimpleDateFormat(
                    "yyyyMMdd_HHmmss", Locale.getDefault())
                    .format(new java.util.Date());

            String filepath = timeStamp + ".jpg";

            try{
                OutputStream fout = null;
                fout = openFileOutput(filepath,MODE_WORLD_READABLE);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fout);
                fout.flush();
                fout.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            saveImage(filepath);
        }
    };
    mMap.snapshot(callback);
}

/**
 * Method to save the screenshot image
 * @param filePath  the file path
 */
public void saveImage(String filePath)
{
    File file = this.getFileStreamPath(filePath);

    if(!filePath.equals(""))
    {
        final ContentValues values = new ContentValues(2);
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.Images.Media.DATA, file.getAbsolutePath());
        final Uri contentUriFile = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Toast.makeText(HuntActivity.this,"Code Saved to files!",Toast.LENGTH_LONG).show();
    }
    else
    {
        System.out.println("ERROR");
    }
}