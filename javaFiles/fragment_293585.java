public static ArrayList<CartData> ParseData(String response) throws JSONException {

    ArrayList<CartData> aluser = new ArrayList<>();

    JSONObject jsonRoot = new JSONObject(response);

    if (jsonRoot == null) {
        return aluser;
    }

    JSONObject jsonObject = jsonRoot.optJSONObject("products");

    if (jsonObject == null) {
        return aluser;
    }

    Iterator<String> keys = jsonObject.keys();

    while (keys.hasNext()) {
        String key = keys.next();

        if (TextUtils.isEmpty(key)) {
            continue;
        }

        JSONObject inside = jsonObject.optJSONObject(key);

        if (inside == null) {
            continue;
        }

        String productId = inside.optString("product_id");
        String product = inside.optString("product");

        if(TextUtils.isEmpty(product) || TextUtils.isEmpty(productId)) {
            continue;
        }

        CartData details1 = new CartData();
        details1.setId(productId);
        details1.setProductname(product);

        aluser.add(details1);


    }
    return aluser;
}