File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
File imageFile = new File(path, getCurrentTime()+ ".png");
FileOutputStream fileOutPutStream = new FileOutputStream(imageFile);
bitmap.compress(Bitmap.CompressFormat.PNG, 80, fileOutPutStream);

fileOutPutStream.flush();
fileOutPutStream.close();