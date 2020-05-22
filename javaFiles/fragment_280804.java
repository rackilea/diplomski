JSONObject jObj = new JSONObject(json);
if(jObj != null) {
    if(jObj.has(TAG_NAME)) {
        song_name = jObj.getString(TAG_NAME);
    }
    if(jObj.has(TAG_ALBUM)){
        album_name = jObj.getString(TAG_ALBUM);
    }
    if(jObj.has(TAG_PRICE)){
        price = jObj.getString(TAG_PRICE);
    }
}