final BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
options.inSampleSize = 2;  //you can also calculate your inSampleSize
options.inJustDecodeBounds = false;
options.inTempStorage = new byte[16 * 1024];

Bitmap bm = BitmapFactory.decodeFile(filePath,options); //changed line code
ByteArrayOutputStream baos = new ByteArrayOutputStream();
bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
byte[] byteArrayImage = baos.toByteArray();
String base64String = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);