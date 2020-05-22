try{
    String url="https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q=Official%20Google%20Blog";
    String jsonData = getUrlContent(url);
    JSONObject googleAPI = new JSONObject(jsonData);
    if (googleAPI!=null){
        JSONObject feed = googleAPI.getJSONObject("responseData");                      
        JSONArray entries = feed.getJSONArray("entries");                                               
        for (int i=0;i<entries.length();i++){
            JSONObject rItem = entries.getJSONObject(i);
            System.out.println("found one entry: " + rItem.toString());
        }                        
    }            
}catch(IOException ex){
    System.out.println("Cannot read url: " + ex.getMessage());
}catch(JSONException ex){
    System.out.println("Problem with JSON: " + ex.getMessage());
}