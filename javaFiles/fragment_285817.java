public static void getValue(String data) {
        try {
        JSONObject responseObject = new JSONObject(data);       
        JSONArray jsonArray = (JSONArray) responseObject.get("data");
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        String result  = jsonObject.getString("password");

        System.out.println(result);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }