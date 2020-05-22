GsonBuilder gsonb = new GsonBuilder()
Gson gson = gsonb.create();

JSONObject j;
JSONObject jo;

Profile p = null;

try {

    j = new JSONObject(convertStreamToString(responseStream));
    jo = j.getJSONObject("profile"); // now jo contains only data within "profile"
    p = gson.fromJson(jo.toString(), Profile.class);
    // now p is your deserialized profile object
}catch(Exception e) {
    e.printStackTrace();
}