Bitmap bm = BitmapFactory.decodeFile("/path/to/image.jpg");
ByteArrayOutputStream baos = new ByteArrayOutputStream();  
bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);   
byte[]  = baos.toByteArray(); 

String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);