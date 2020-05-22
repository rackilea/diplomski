String json = " [{\"invoiceid\":\"0147708\"}]";

JSONArray array = (JSONArray) new JSONParser().parse(json);
//JSONArray array = (JSONArray) jsonObject.get("invoiceid");

List<String> jsonList = new ArrayList<String>();
for (int i = 0; i < array.size(); i++) {
    jsonList.add(((JSONObject) array.get(i)).toString());
}
String[] invoices = jsonList.toArray(new String[0]);