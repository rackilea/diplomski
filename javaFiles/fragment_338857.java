BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = false;
InputStream imageStream = context.getContentResolver().openInputStream(uri);
Bitmap bitmap = BitmapFactory.decodeStream(imageStream, null, options);
imageStream.close();

imageview.setImageBitmap(bitmap);