JSONObject root = new JSONObject(json);

JSONArray myData = (JSONArray) root.get("myData");

myData.remove(0);
myData.put(4);

System.out.println("root = " + root.toString());