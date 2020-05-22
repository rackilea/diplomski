String in = "{\"employees\": [{\"firstName\": \"John\",\"lastName\": \"Doe\"},{\"firstName\": \"Anna\",\"lastName\": \"Smith\"},{\"firstName\": \"Peter\",\"lastName\": \"Jones\"}]}";

try {
    String country = "";
    JSONObject jObj = new JSONObject(in);

        JSONArray jArray = jObj.getJSONArray("employees");
        for(int j=0; j <jArray.length(); j++){
            JSONObject sys = jArray.getJSONObject(j);
             country += "  " + sys.getString("firstName");
        }



    Toast.makeText(this, country, Toast.LENGTH_LONG).show();

} catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();

};