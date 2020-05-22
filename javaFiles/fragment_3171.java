private static Map getMap(JSONObject object, String json) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Object jsonObject = null;

        Iterator<String> keys = object.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = object.get(key);

            if (value instanceof JSONObject) {
                map.put(key, getMap((JSONObject) value, json));
                continue;
            }

         // If value is in the form of array

            if (value instanceof JSONArray) {
                JSONArray array = ((JSONArray) value);
                List list = new ArrayList();
                for (int i = 0 ; i < array.length() ; i++) {
                    jsonObject = array.get(i);
                    if (jsonObject instanceof JSONObject) {
                        list.add(getMap((JSONObject) jsonObject, json));
                    } else {
                        list.add(jsonObject);

                    }
                }
                map.put(key, list);
                continue;
            }

            map.put(key, value);
        }
        return map;
    }