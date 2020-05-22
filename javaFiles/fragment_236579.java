public static void main(String[] args) throws JSONException {
        JSONObject j = new JSONObject("{\"stops\": [{\"stop_id\": \"3734\",\"stop_code\": \"5266\"},{\"stop_id\": \"2750\",\"stop_code\": \"5268\"}]}");        
        JSONArray array = j.getJSONArray("stops");
        for (int i = 0; i < array.length(); i++) {
            System.out.println(array.getJSONObject(i).getString("stop_id"));
        }
    }