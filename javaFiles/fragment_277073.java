@Override
protected String doInBackground(String... urls) {

    // Download JSON data from URL
    try {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(urls[0]);
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        is = entity.getContent();

    } catch (Exception e) {
        Log.e("log_tag", "Error in http connection " + e.toString());
    }

    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        is.close();


        //     this.jArray = new JSONArray(result);
    } catch (Exception e) {
        Log.e("log_tag", "Error converting result " + e.toString());
    }

    ArrayList<SalesItem> all_sales = new ArrayList<SalesItem>();
    JSONArray jArray;
    try {
        jArray = new JSONArray(sb.toString());
        int total_retail_outlets = jArray.length();
        for (int i = 0; i < total_retail_outlets; i++) {
                JSONObject jObj = jArray.getJSONObject(i);

                String customer_name = jObj.getString("name");
                String created_at = jObj.getString("created_at");
                String quantity = jObj.getString("quantity");
                String billing_amount = jObj.getString("billing_amount");
                String discount_percentage = jObj.getString("discount_percentage");
                String discount = jObj.getString("discount");
                String total = jObj.getString("total");
                SalesItem salesData = new SalesItem();
                salesData.setBilling_amount(billing_amount);
                salesData.setCreated_at(created_at);
                salesData.setCustomer_name(customer_name);
                salesData.setDiscount(discount);
                salesData.setDiscount_percentage(discount_percentage);
                salesData.setQuantity(quantity);
                salesData.setTotal(total);

                all_sales.add(salesData);
            }
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();

    return all_sales;
}