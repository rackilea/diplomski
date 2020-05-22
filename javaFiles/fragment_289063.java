private int isExisting(String pid, List profile, String size) throws JSONException {
       for (int i = 0; i < profile.size(); i++) {
           JSONObject obj = (JSONObject) profile.get(i);
           log.info("--------------" + obj.toString());   
       }
    }