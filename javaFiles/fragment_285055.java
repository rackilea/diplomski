b.putString("userName", name);
b.putString("userEmail", email);
profileIntent.putExtras(b);

ByteArrayOutputStream stream = new ByteArrayOutputStream();
bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
byte[] byteArray = stream.toByteArray();
profileIntent.putExtra("user_pic", byteArray);

startActivity(profileIntent);