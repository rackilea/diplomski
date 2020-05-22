JSONObject root = new JSONObject(tokener);
    Iterator<?> keys = root.keys();

    while(keys.hasNext()){
        String key = (String)keys.next();
        System.out.println(key + "=" + root.getString(key));
    }