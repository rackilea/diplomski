Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.yourImage);
ByteArrayOutputStream stream=new ByteArrayOutputStream();
bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
byte[] image=stream.toByteArray();


String imageToStoreInYourClass = Base64.encodeToString(image, 0);