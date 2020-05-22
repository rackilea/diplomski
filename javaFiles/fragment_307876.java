JSONParser parser = new JSONParser();

Object obj = parser.parse(new FileReader(
        "sample.json"));

JSONArray jsonArray = (JSONArray) obj;
for (int i = 0; i < jsonArray.size(); i++) {
    System.out.println("Before --" + jsonArray.get(i).toString());
    JSONObject jsonObject = (JSONObject)jsonArray.get(i);
    jsonObject.remove("selected");
    System.out.println("After --" + jsonArray.get(i).toString());
}
System.out.println("Final Output --" + jsonArray.toString());