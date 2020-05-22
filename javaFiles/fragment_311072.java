/**
 * Converts a immutable bitmap to a mutable bitmap. This operation doesn't allocates
 * more memory that there is already allocated.
 * 
 * @param imgIn - Source image. It will be released, and should not be used more
 * @return a copy of imgIn, but muttable.
 */
public static Bitmap convertToMutable(Bitmap imgIn) {
    try {
        //this is the file going to use temporally to save the bytes. 
        // This file will not be a image, it will store the raw image data.
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "temp.tmp");

        //Open an RandomAccessFile
        //Make sure you have added uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"
        //into AndroidManifest.xml file
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

        // get the width and height of the source bitmap.
        int width = imgIn.getWidth();
        int height = imgIn.getHeight();
        Config type = imgIn.getConfig();

        //Copy the byte to the file
        //Assume source bitmap loaded using options.inPreferredConfig = Config.ARGB_8888;
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(MapMode.READ_WRITE, 0, imgIn.getRowBytes()*height);
        imgIn.copyPixelsToBuffer(map);
        //recycle the source bitmap, this will be no longer used.
        imgIn.recycle();
        System.gc();// try to force the bytes from the imgIn to be released

        //Create a new bitmap to load the bitmap again. Probably the memory will be available. 
        imgIn = Bitmap.createBitmap(width, height, type);
        map.position(0);
        //load it back from temporary 
        imgIn.copyPixelsFromBuffer(map);
        //close the temporary file and channel , then delete that also
        channel.close();
        randomAccessFile.close();

        // delete the temp file
        file.delete();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } 

    return imgIn;
}