JSONObject jsonBody = new JSONObject();
    try{

        jsonBody.put("userName", "uname");
        jsonBody.put("password", "pass123");
    }
    catch (JSONException e){

    }

    final String requestBody = jsonBody.toString();