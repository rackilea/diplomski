List<HashMap<String,String>> response = new ArrayList<>();
JSONArray jsonarray = null;
    try {
        jsonarray = new JSONArray(json);
        for(int i=0;i<jsonarray.length();i++) {
            JSONObject jsonObject = jsonarray.getJSONObject(i);
            Iterator<?> iterator = jsonObject.keys();
            HashMap<String,String> map = new HashMap<>();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                Object value = jsonObject.get(key.toString());
                map.put(key.toString(),value.toString());

            }
            response.add(map);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }