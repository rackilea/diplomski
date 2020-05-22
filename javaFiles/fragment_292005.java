ByteArrayOutputStream stream = new ByteArrayOutputStream();
bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
byte[] byteArray = stream.toByteArray();

dba.open();

dba.insertPhoto(byteArray);