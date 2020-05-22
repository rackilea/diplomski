String message =null;
JSONObject json = new JSONObject();
json.put("name","Atal");
json.put("class", "10");
json.put("Roll","1035");


JSONArray array = new JSONArray();

array.put(json);
message = array.toJSONString();