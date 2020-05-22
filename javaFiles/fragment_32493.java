@Override
public void onResponse(JSONObject response) {
       String city = response.getString("city");
       String country= response.getString("country");
       String ip = response.getString("query");
}