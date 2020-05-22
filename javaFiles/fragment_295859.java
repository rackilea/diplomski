//Parse string to JSON object
    try {
        jarray = new JSONObject(builder.toString());
    } catch (JSONException e) {
        Log.e("JSON Parser", "Error parsing data " + e.toString());
    }

    //Return json to array
    return jarray;