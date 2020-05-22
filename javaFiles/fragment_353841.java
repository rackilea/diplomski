SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);   

//Save String
preferences.edit().putString("image64", imageData).commit();

//Get String
String imageBase64 = preferences.getString("image64", null);
                                                       ^----- Default value
if(imageBase64 == null)
    Log.d("LOG", "No image stored in the SharedPreferences");

//Create a bitmap from the base64 data
byte[] decodedString = Base64.decode(imageBase64, Base64.DEFAULT);
Bitmap bm = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);