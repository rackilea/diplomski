String jsonStr = "[{\"No\":\"1\",\"Name\":\"ABC\"},{\"No\":\"2\",\"Name\":\"PQR\"},{\"No\":\"3\",\"Name\":\"XYZ\"}]";

   JSONArray array = new JSONArray(jsonStr); 

    for(int i=0; i<array.length(); i++){
        JSONObject jsonObj  = array.getJSONObject(i);
        System.out.println(jsonObj.getString("No"));
        System.out.println(jsonObj.getString("Name"));
    }