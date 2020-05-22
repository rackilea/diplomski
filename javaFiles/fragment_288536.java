try {
        JSONArray jsonArray = new JSONArray(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            JSONArray orderDetails = jsonObject.getJSONArray("orderDetails");
            for (int j = 0; j < orderDetails.length(); j++) {
                JSONObject jsonObject2 = orderDetails.getJSONObject(j);
                String account_name = jsonObject2.getString("account_name");
                txt_accountName.setText(account_name);
            }
        }
} catch (JSONException e) {
        e.printStackTrace();
}