JSONObject c = resorts.getJSONObject(i);
JSONObject d = rates.getJSONObject(i);

// Storing each json item in variable
String name = c.getString(TAG_NAME);
String price = d.getString(TAG_ROOM_PRICE);