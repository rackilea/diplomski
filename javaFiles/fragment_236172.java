JSONObject returnedJObject= new JSONObject();
JSONObject KeyvalspairJObject=new JSONObject ();
JSONObject devcKeyvalspairJObject=new JSONObject ();
JSONObject capabilityJObject=new JSONObject();
JSONObject ScreenDimensionsJObject =new JSONObject();
JSONObject deviceJObject= new JSONObject();
try{
    KeyvalspairJObject.put("key1","val1");
    KeyvalspairJObject.put("key2","val2");
    capabilityJObject.put("sms", false);
    capabilityJObject.put("data", true);
    capabilityJObject.put("gps", true);
    capabilityJObject.put("wifi", true);
    capabilityJObject.put("keyValue", KeyvalspairJObject);
    ScreenDimensionsJObject.put("width", 45);
    ScreenDimensionsJObject.put("height", 45);
    devcKeyvalspairJObject.put("Devckey1","val1");
    devcKeyvalspairJObject.put("DEVCkey2","val2");
    deviceJObject.put("userAgent", "MYUserAgent");
    deviceJObject.put("capabilities", capabilityJObject);
    deviceJObject.put("screen", ScreenDimensionsJObject);
    deviceJObject.put("keyValue", devcKeyvalspairJObject);

    returnedJObject.put("clientId", "ID:1234-1234");
    returnedJObject.put("carrier","TMobile");
    returnedJObject.put("device",deviceJObject);
    returnedJObject.put("time",1294617435);
    returnedJObject.put("msisdn","1234567890");
    returnedJObject.put("timezone","GMT");
}
catch(JSONException e)
{
}