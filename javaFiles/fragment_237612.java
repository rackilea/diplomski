String responceStr = ...; // here is your full responce string
    try {
        JSONObject responce = new JSONObject(responceStr);
        String status = responce.getString("output");
        if ("success".equalsIgnoreCase(status)) {
            JSONArray result = responce.getJSONArray("result");
            for (int i=0; i < result.length(); i++){
                JSONObject jsonPair = result.getJSONObject(i);
                int id = jsonPair.getInt("id");
                String label = jsonPair.getString("label");
            }
        }
    } catch (JSONException e){

    }