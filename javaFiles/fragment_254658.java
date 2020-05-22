// image naming and path  to include sd card  appending name you choose for file
String mPath = Environment.getExternalStorageDirectory().toString() + "/" + ACCUWX.IMAGE_APPEND;   

// create bitmap screen capture
Bitmap bitmap;
View v1 = mCurrentUrlMask.getRootView();
v1.setDrawingCacheEnabled(true);
bitmap = Bitmap.createBitmap(v1.getDrawingCache());
v1.setDrawingCacheEnabled(false);

OutputStream fout = null;
imageFile = new File(mPath);

try {
   fout = new FileOutputStream(imageFile);
   bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fout);
   fout.flush();
   fout.close();
} catch (FileNotFoundException e) {
   e.printStackTrace();
} catch (IOException e) {
   e.printStackTrace();
}