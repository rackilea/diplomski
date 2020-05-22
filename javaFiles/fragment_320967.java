JSONObject object=new JSONObject();
try {
    object.put("key", value);
    object.put("key", value);

}catch (JSONException e){}


// make a request this should run on ui thred
String urlString = "";
RestHelper restHelper = new RestHelper(context);
RequestFuture requestFuture = RequestFuture.newFuture();
response = restHelper.postRequestTest(urlString,object,requestFuture);
System.out.println("Json Data" + response.toString() );

//libraries need to compile
compile 'com.mcxiaoke.volley:library:1.0.19'
compile 'com.google.code.gson:gson:2.3'