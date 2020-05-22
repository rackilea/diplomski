File sd = Environment.getExternalStorageDirectory();
File image = new File(sd+filePath, imageName);
BitmapFactory.Options bmOptions = new BitmapFactory.Options();
Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
bitmap = Bitmap.createScaledBitmap(bitmap,parent.getWidth(),parent.getHeight(),true);
imageView.setImageBitmap(bitmap);