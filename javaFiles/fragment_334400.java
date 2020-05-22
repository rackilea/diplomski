BitmapDrawable bitmapDrawable = ((BitmapDrawable) drawable);
Bitmap bitmap = bitmapDrawable .getBitmap();
ByteArrayOutputStream stream = new ByteArrayOutputStream();
bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
byte[] imageInByte = stream.toByteArray();
ByteArrayInputStream bis = new ByteArrayInputStream(imageInByte);