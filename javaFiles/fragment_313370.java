@Override
public String createImgName() {
  try {
    JSONObject data = getJSONData();
    // data["image"]["full"]
    if (data.has("image")) {
      return data.getJSONObject("image").getString("full");
    } else if (data.has("id")) {
      return data.getJSONObject("id")+".png";
    }
  }
  catch(JSONException e) {
    return null;
  }
}