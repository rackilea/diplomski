public static String getStringFromJSON(JSONObject json, String key){


    String value = ""; // Blank string by default.  

    try {       

        String value = json.getString(key);


        return value;
    }
        catch(JSONException exp){

        exp.getMessage();

    }

    return value;  // this wil return BLANk string if object is not prasent.

}