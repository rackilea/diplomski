JSONObject dataset = new JSONObject();
dataset.put("date", currentTime);
dataset.put("id", currentID);
dataset.put("key", key);

JSONArray payload = new JSONArray();
JSONObject data = new JSONObject();

Iterator it = currentValues.entrySet().iterator();
while (it.hasNext()) {
Map.Entry pair = (Map.Entry)it.next();
data.put("type", pair.getKey()) ;
data.put("value", pair.getValue()) ;
it.remove(); // avoids a ConcurrentModificationException
}
JSONArray mapArray = new JSONArray();
mapArray.add(data);
dataset.put("data", mapArray);
payload.add(dataset);