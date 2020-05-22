String location = Environment.getExternalStorageDirectory() + "/ImageFolder/";

//Creating Folder Directory 
File imageDir = new File(location);
dir.mkdirs();

//Creating Image file
String imageName = "sketch.png";

File imageFile = new File(imageDir, imageName);

//If image file already exists then delete it.
if (imageFile.exists()) {
    imageFile.delete();
}

//Writing the image to SDCard
try {
    FileOutputStream out = new FileOutputStream(imageFile);
    back.compress(Bitmap.CompressFormat.JPEG, 100, out);
    out.flush();
    out.close();

} catch (Exception e) {
    e.printStackTrace();
}