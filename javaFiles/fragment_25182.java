JSONObject jsonObject = new JSONObject(jsonString);
 JSONObject lights = jsonObject.getJSONObject("lights");
 Iterator<String> keyIterator = lights.keys();

 while (keys.hasNext()) {
     String key = keyIterator.next();
     JSONObject l = lights.getJSONObject(key);

     String name = l.getString("name");
     String bri = l.getString("bri");
     String hue = l.getString("hue");
     String sat = l.getString("sat");
     String status = l.getString("on");
 }