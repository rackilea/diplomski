try {    
          String response ="[{\"FOOD_ID\":\"1\",\"FOOD_NAME\":\"Rice\"},{\"FOOD_ID\":\"2\",\"FOOD_NAME\":\"Daal\"}] ";
           JSONArray array;

            array = new JSONArray(response);

           for (int i = 0; i < array.length(); i++) {
             JSONObject obj = array.getJSONObject(0);
             String id_fd = obj.getString("FOOD_ID");
             String name_fd = obj.getString("FOOD_NAME");
             Log.d("JSONArray", id_fd+"   " +name_fd);
        }} catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }