public String getParameters(JSONObject json) throws JSONException {

    String jsonString;
    if ((jsonString = json.getJSONObject("rrr").getJSONObject("test")
            .optString("a2",null)) != null) {
    //       ^^^            ^^^^ <- default value in case of lack of element
        return jsonString;
    } else
        return "not Found";

}