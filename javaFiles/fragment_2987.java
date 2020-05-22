StringBuilder yourJsonString= new StringBuilder();
String line;
while ((line = strResponse.readLine()) != null) {
      yourJsonString.append(line);
}
JSONArray jsonObject = new JSONArray(yourJsonString.toString());
//retrieve the second element of json array
JSONArray secondElmArray= jsonObject.getJSONArray(1);
JSONArray innerArray = secondElmArray.getJSONArray(0);

JSONArray urduList= innerArray.getJSONArray(1);
String urduWord= urduList.getString(0);