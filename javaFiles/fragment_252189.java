final String TAG = "MyAppTag";

File picturesDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
File imageFile = null;
final int readLimit = 16 * 1024;
if(picturesDir != null){
    imageFile = new File(picturesDir, "01.gif");
} else {
    Log.w(TAG, "DIRECTORY_PICTURES is not available!");
}
if(imageFile != null){
    mInputStream =  new BufferedInputStream(new FileInputStream(imageFile), readLimit);
    mInputStream.mark(readLimit);
} else {
    Log.w(TAG, "GIF image is not available!");
}