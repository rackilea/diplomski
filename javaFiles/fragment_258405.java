JSONObject mainObject = new JSONObject(json_data_in_a_string);
JSONObject jsonAPI = mainObject.getJSONObject("jsonapi");
JSONArray array = (JSONArray)jsonAPI.get("data");

for (int i = 0; i < array.length(); i++) {

    JSONObject childObject = array.getJSONObject(i);
    String id = childObject.getString("id");

    JSONObject name = childObject.getJSONObject("name");
    String name_en= name.getString("en");
    String name_es = name.getString("es");

    JSONObject company = childObject.getJSONObject("company");
    String company_id = company.getString("id");
    String company_name = company.getString("name");

}