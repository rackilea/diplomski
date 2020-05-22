JSONArray  myArray=JSONfunctions.getJSONfromURL("http://abc.com/getjson.php");

for(int i=0;i<myArray.length();i++){

JSONObject  myobj = myArray.getJSONObject(i);

 // get date here
  String strdate=myobj.getString("date");

 // get activity here
  String stractivity=myobj.getString("activity");
}