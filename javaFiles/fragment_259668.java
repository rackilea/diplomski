public void onResponse(JSONObject object) {
    Log.i("gw2Log", "Json Response" + object);

    resultClass resultClass = new resultClass();

    try {
        resultClass.setCount(object.getInt("count"));
        resultClass.setPage(object.getInt("page"));
        resultClass.setLast_page(object.getInt("last_page"));
        resultClass.setTotal(object.getInt("total"));
        JSONArray list = new JSONArray(object.getString("results"));

        for (int i = 0; i < resultClass.getTotal(); i++) {
            JSONObject resultsObject = list.getJSONObject(i);
            MyObject temp = new MyObject();
            temp.setData_id(resultsObject
                    .getInt("data_id"));
            temp.setName(resultsObject
                    .getString("name"));
            temp.setRarity(resultsObject
                    .getInt("rarity"));
            temp.setRestriction_level(resultsObject
                    .getInt("restriction_level"));
            temp.setImg(resultsObject
                    .getString("img"));
            temp.setType_id(resultsObject
                    .getInt("type_id"));
            temp.setSub_type_id(resultsObject
                    .getInt("sub_type_id"));
            temp.setPrice_last_changed(resultsObject
                    .getString("price_last_changed"));
            temp.setMax_offer_unit_price(resultsObject
                    .getInt("max_offer_unit_price"));
            temp.setMin_sale_unit_price(resultsObject
                    .getInt("min_sale_unit_price"));
            temp.setOffer_availability(resultsObject
                    .getInt("offer_availability"));
            temp.setSale_availability(resultsObject
                    .getInt("sale_availability"));
            temp.setSale_price_change_last_hour(resultsObject
                    .getInt("sale_price_change_last_hour"));
            temp.setOffer_price_change_last_hour(resultsObject
                    .getInt("offer_price_change_last_hour"));
            resultClass.addObject(temp);
        }

    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    for(int i = 0; i < resultClass.total; i++) {
        Log.i("gw2Log", resultClass.getObject(i).name);
    }
}