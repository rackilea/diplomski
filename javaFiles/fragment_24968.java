//create a file to write bitmap data
File f = new File(context.getCacheDir(), filename);
f.createNewFile();

//Convert bitmap to byte array
Bitmap bitmap = your bitmap;
ByteArrayOutputStream bos = new ByteArrayOutputStream();
bitmap.compress(CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
FileOutputStream fos = new FileOutputStream(f);
fos.write(bitmapdata);
fos.flush();
fos.close();