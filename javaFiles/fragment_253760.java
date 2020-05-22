public void saveBitmap(Bitmap bitmap) {

File root = android.os.Environment.getExternalStorageDirectory(); 
File dir = new File (root.getAbsolutePath() + "/bBackground");
if (!dir.exists()) {
    dir.mkdirs();
 }
File image = new File(dir, "/bBg.jpg");

try {
    FileOutputStream out = new FileOutputStream(image);
    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
    out.flush();
    out.close();    
} catch (FileNotFoundException e) {
    e.printStackTrace();
    Log.i(TAG, "******* File not found. Did you" +
            " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
} catch (IOException e) {
    e.printStackTrace();
 }   
}