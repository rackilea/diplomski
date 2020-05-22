private HashMap<String,JSONObject> getLowfaresJson(JSONObject data){
    HashMap<String,JSONObject> result = new HashMap<>();


    try {
        JSONObject lowfareJson = data.getJSONObject("lowfares");
        Iterator keys = lowfareJson.keys();

        while ((keys.hasNext())){
            //Getting dynamic key from json
            String currentDynamicKey = (String) keys.next();

            //Getting dynamic value from json
            JSONObject currentDynamicValue = lowfareJson.getJSONObject(currentDynamicKey);
            result.put(currentDynamicKey,currentDynamicValue);

        }


    } catch (JSONException e) {
        e.printStackTrace();
    }

    return result;

}