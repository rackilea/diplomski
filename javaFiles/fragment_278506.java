private void saveAnImageToExternalMemory(Bitmap finalBitmap) {
    String root = Environment.getExternalStorageDirectory().toString();
    File myDir = new File(root + "/saved_images");    
    myDir.mkdirs();
    String fname = "yourimagename.jpg";
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
}