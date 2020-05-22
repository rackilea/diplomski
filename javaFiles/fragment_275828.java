String cssClass = myJson.getString("cssClass");
if (cssClass.equals("input_text")){
    // Read it as a String
    String values = myJson.getString("values");
}
else if (cssClass.equals("checkbox")){
    // Read it as a JSONObject
    JSONObject values = myJson.JSONObject("values");
    // further processing here
}