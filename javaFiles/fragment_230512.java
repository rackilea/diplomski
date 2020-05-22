String myJSONString = "{\"code1\":\"Text I want copied\",\"code2\":\"Second text I want to copy\"}";
JSONObject object = new JSONObject(myJSONString);
String[] keys = JSONObject.getNames(object);

String firstText = (String) object.get(keys[0]);
String secondText = (String) object.get(keys[1]);