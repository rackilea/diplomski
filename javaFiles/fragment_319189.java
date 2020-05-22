JSONArray jsonArray = new JSONArray(responseString);
     int size = jsonArray.length();
     ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
     for(int i= 0; i< size; i++) {
          JSONObject jsonObject = jsonArray.optJSONObject(i);
          // use this jsonObject to get the value by passing the keys.
           String value = jsonObject.optString(key);

           //here is your array list of jsonobjects
           arrayList.add(jsonObject);
     }