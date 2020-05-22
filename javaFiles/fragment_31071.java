public CustomerInfo(String jsonTxt) {
try {
    JSONObject json = new JSONObject(jsonTxt);
        JSONObject customer = new JSONObject(json.getString("CustomerInfo"));
        JSONObject client = new JSONObject(customer.getString("clientDisplay"));
        custNo = client.getString("globalCustNum");
    custName = client.getString("displayName");
        JSONObject cph = new JSONObject(customer.getString("clientPerformanceHistory"));
        JSONObject caddress = new JSONObject(customer.getString("address"));
    address = caddress.getString("displayAddress");
    savAcctBal =  cph.getDouble("totalSavingsAmount");
} catch (final JSONException je) {
        je.printStackTrace();
}
}