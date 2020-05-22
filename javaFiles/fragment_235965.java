public String parseJSONForTranslation(String jsonString) {
    try {
        JSONObject object = (JSONObject) new JSONTokener(jsonString).nextValue();
        return object.getJSONObject("data").getJSONArray("translations").
                getJSONObject(0).getString("translatedText");
    }
    catch (JSONException e) {
        return null;
    }
}