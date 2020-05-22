String url = "http://google.com";
String jsonString = //get it from SharedPreferences

if(jsonString.replace("\\", "").contains(url)) {
      Toast.makeText(context, "URL already exists.", Toast.LENGTH_LONG).show();
}