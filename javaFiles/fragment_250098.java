try {
        JSONObject jsonObject = new JSONObject(response);
        JSONArray elements = jsonObject.getJSONArray("elements");
        for (int i = 0; i < elements.length(); i++) {
            JSONObject jsonObject1 = elements.getJSONObject(i);
            String name = jsonObject1.optString("name");
            String value = jsonObject1.optString("value");
            JSONObject format = jsonObject1.optJSONObject("format");
            JSONObject Text = format.optJSONObject("Text");
            String orientation = Text.optString("orientation");
            String height = Text.optString("height");
            String width = Text.optString("width");
        }
} catch (JSONException e) {
        e.printStackTrace();
}