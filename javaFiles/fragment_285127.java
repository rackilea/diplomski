JSONArray ar = new JSONArray(content);
    for(int i=0; i<ar.length(); i++){
        JSONObject obj = ar.getJSONObject(i);

        //here is your desired object
        p_class p = gson.fromJson(obj.getJSONObject("brand").toString(), p_class.class);
    }