File myDir=new File("/sdcard/folder_you_want_to_save_in");
myDir.mkdirs();

String fname = "JPEG_"+ timeStamp +".jpg";

File file = new File (myDir, fname);

if (file.exists ()) file.delete (); 

try {
    FileOutputStream out = new FileOutputStream(file);
    finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
    out.flush();
    out.close();

} catch (Exception e) {
    e.printStackTrace();
}