JSONParser jParser = new JSONParser();
JSONObject jObject = (JSONObject) jParser.parse(new FileReader("c:\\file.json"));

for(Object key : jObject.keySet()) {
    JSONObject customerWrapper = (JSONObject)jObject.get(key);
    JSONObject customer = (JSONObject)customerWrapper.get("customer");
    System.out.println(customer.get("name"));
}