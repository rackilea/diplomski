JSONObject obj = new JSONObject(historie2.getData());
            Iterator<?> keys = obj.keys();

            while(keys.hasNext()) {
                String key = (String)keys.next();
                JSONArray value =  obj.getJSONArray(key); 

            }