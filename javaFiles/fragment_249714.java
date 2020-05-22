private String convertToJsonString(ArrayList<ArrayList<String>> allActionsList) 
{
    JSONObject jObj = new JSONObject();
    JSONObject events = new JSONObject();
    JSONArray eventX;
    int count = 1;
    String key;

    try {
        for(ArrayList<String> array : allActionsList){
            key = String.format("Event %d", count);
            eventX = new JSONArray();
            for(String s : array){
                eventX.put(s);
            }
            events.put(key, eventX);
            count++;
        }
        jObj.put("events", events);

    } catch(Exception e){
        // failed somewhere to create JSON object
        e.printStackTrace();
    }
    return jObj.toString();
}