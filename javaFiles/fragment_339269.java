try {
    JSONObject jsonObject = new JSONObject(result);
    int iduser = jsonObject.getInt("iduser");
} catch (JSONException e) {
    Log.d("ErrorOn:iduser", e.toString());
}