JSONObject usd = getObjectFromJsonArray.getJSONObject("quotes").getJSONObject("USD");

if (usd.has("price")){
    coin.setPrice(usd.getDouble("price"));
}else{
    Log.d(TAG, "No price");
}