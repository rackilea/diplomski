JSONArray arr = new JSONArray();
JSONObject obj;
for( int i = 0; i < yourUserArr.length; i++ ){
  obj = new JSONObject();
  obj.put("user", yourUserArr[i]);
  obj.put("password", yourPassArr[i]);
  arr.put( obj );
}