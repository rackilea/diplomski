try {
    JSONObject main_obj = new JSONObject(loadJSONFromAsset());
    JSONObject article= main_obj.getJSONObject("article");
    String title=article.getString("title");
    Button button = new Button(this);
    button.setText(title);
    linearLayout.addView(button);

} catch (JSONException e) {
    e.printStackTrace();
}