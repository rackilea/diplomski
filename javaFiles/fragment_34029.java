Bitmap bmp =  BitmapFactory.decodeResource(getResources(),
        R.drawable.chicken);//your image
ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
bmp.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
bmp.recycle();
byte[] byteArray = bYtE.toByteArray();
String imageFile = Base64.encodeToString(byteArray, Base64.DEFAULT);