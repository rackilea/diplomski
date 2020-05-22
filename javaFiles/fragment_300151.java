...
String jsonString = stringResponse;

jsonString = jsonString.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>"," ");
jsonString = jsonString.replace("<string xmlns=\"tempuri.org/\">"," ");
jsonString = jsonString.replace("</string>"," ");
try {
    JSONObject jsonObject = new JSONObject(jsonString);
} catch (JSONException e) {
    e.printStackTrace();
}
...