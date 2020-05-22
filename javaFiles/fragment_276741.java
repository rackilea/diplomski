Map<String, String> myMap = new HashMap<String,String>();
myMap.put("apple","mac");
JSONObject listOfEntities = new JSONObject();

for (String key : myMap.keySet){
    listOfEntities.put(key, myMap.get(key));
}