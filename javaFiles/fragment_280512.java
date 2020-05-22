//first, retrieve the data from the response JSON Object from the server
JSONObject response = new JSONObject(jsonString);
String status = response.getString("status");
String message = response.getString("message");
//Note this: "data" is a string as well, but we'll have to parse that later.
String data = response.getString("data");

//get the doubles from the arrays from the "data" component.
JSONObject dataObject = new JSONObject(data);
JSONArray start = dataObject.getJSONArray("start");
JSONArray end = dataObject.getJSONArray("end");

for (int i = 0; i < start.length(); i++) {
    String value = start.getString(i);
    //do something with the start String (parse to double first)
}
for (int i = 0; i < end.length(); i++) {
    String value = end.getString(i);
    //do something with end String (parse to double first)
}