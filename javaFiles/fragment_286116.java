JSONObject obj=new JSONObject(response);//This is response from webservice
    String totalCount = obj.getJSONObject("meta").getString("total_count"); //for getting total_count
    JSONArray json_array = obj.getJSONArray("objects");
    for(int j=0;j<json_array.length();j++) {
        String title = json_array.getJSONObject(j).getString("Title");
        String location= json_array.getJSONObject(j).getString("Location");
    }