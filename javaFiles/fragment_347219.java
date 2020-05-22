// looping through All JSON array
HashMap<String, List<String>> ExpListData = new HashMap<String, List<String>>();
for (int i = 0; i < data.length(); i++) {
     JSONObject c = data.getJSONObject(i);

     // Storing each json item in variable
     String city = c.getString(TAG_CITY);
     String street = c.getString(TAG_STREET);

     List<String> streets = ExpListData.get(key);
     if (streets == null) {
         streets = new ArrayList<String>();
         ExpListData.put(key, streets);
     }
     streets.add(value);
 }