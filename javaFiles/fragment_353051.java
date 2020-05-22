JSONObject coinArray = response.getJSONObject("data");
Iterator<String> iter = coinArray.keys();
while (iter.hasNext()) {
    String key = iter.next();
    try {
        Object coinOBJ = coinArray.get(key);

        CoinMarketAPI coin = new CoinMarketAPI();
        coin.setId(coinOBJ.getString("id"));
        coin.setName(coinOBJ.getString("name"));
        coin.setSymbol(coinOBJ.getString("symbol"));
        coin.setWebsite_slug(coinOBJ.getString("website_slug"));
        coin.setRank(Integer.parseInt(coinOBJ.getString("rank")));
        coin.setCirculating_supply(coinOBJ.getString("circulating_supply"));
        coin.setTotal_supply(coinOBJ.getString("total_supply"));
        coin.setQuotes(coinOBJ.getString("quotes"));
        coin.setUSD(coinOBJ.getString("USD"));
        coin.setPrice(coinOBJ.getString("price"));

        Log.d(TAG, coin.getName());
        firstlist.add(coin);
    } catch (JSONException e) {
        // Something went wrong!
    }
}