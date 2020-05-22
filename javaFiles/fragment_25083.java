// create file from drawable image
Bitmap bm = BitmapFactory.decodeResource(this.getResources(), R.drawable.yourbeautifulimage);

File filesDir = getApplicationContext().getFilesDir();
File imageFile = new File(filesDir, "ABeautifulFilename.png");

OutputStream os;
try {
    os = new FileOutputStream(imageFile);
    bm.compress(Bitmap.CompressFormat.PNG, 100, os); // 100% quality
    os.flush();
    os.close();
} catch (Exception e) {
    Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
}