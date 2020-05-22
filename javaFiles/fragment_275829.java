String cssClass = myJson.getString("cssClass");
String values = myJson.getString("values");

if (cssClass.equals("input_text")){
    // do nothing - it's already a String
}
else if (cssClass.equals("checkbox")){
    // Parse the String into a JSONObject
    JSONObject valuesObject = new JSONObject(values);
    // further processing here
}