Iterator<String> keys = jsonMap.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = jsonMap.getString(key);
            map.put(key, value);
        }