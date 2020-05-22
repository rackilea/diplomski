try{
        JSONObject obj = new JSONObject(response);
        String name= obj.getString("name");
        String user_id= obj.getString("user_id");
        String value= obj.getString("value");

       /
    }catch (JSONException e) {
        e.printStackTrace();
    }