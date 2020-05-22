JSONParser parser = new JSONParser();

Object obj = parser.parse(new FileReader("simple.json"));

JSONObject jsonObject = (JSONObject) obj;

for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
    String key = (String) iterator.next();
    System.out.println(jsonObject.get(key));
}