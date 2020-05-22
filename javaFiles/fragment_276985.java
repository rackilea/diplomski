.
.
.
for (int i = 0; i < parentarray.length(); i++) {

    JSONObject finalObject = parentarray.getJSONObject(i);
    photoid = finalObject.optString("id");
    farm = finalObject.optInt("farm");
    server = finalObject.optString("server");
    secret = finalObject.optString("secret");  
    String fullPath = "https://farm" + farm + ".staticflickr.com/" + server + "/" + photoid+ "_" + secret + ".jpg";

    values.add(fullPath); 
}
.
.
.