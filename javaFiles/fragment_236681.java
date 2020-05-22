try{
        String json = "JSON source";
        JSONObject j = new JSONObject(json);
        JSONArray arr = j.getJSONObject("query").getJSONObject("results").getJSONArray("array");
        for(int i=0; i<arr.length(); i++){
            JSONObject obj = arr.getJSONObject(i);
            String sy = obj.getString("Sy");
            String date = obj.getString("Date");
            String o = obj.getString("O");
            String h = obj.getString("H");
            String l = obj.getString("L");
            String c = obj.getString("C");
            String v = obj.getString("V");
        }
    }
    catch(JSONException e){

    }