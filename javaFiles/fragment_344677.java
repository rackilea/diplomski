StringBuilder builder = new StringBuilder();
BufferedReader reader = new BufferedReader(new FileReader(new File("resources/json2.txt")));
String line = null;
while ((line = reader.readLine()) != null) {
    builder.append(line);
}
reader.close();

Gson gson = new Gson();
Type listType = new TypeToken<ArrayList<Map<String, Object>>>() {
}.getType();
ArrayList<Map<String, Object>> list = gson.fromJson(builder.toString(), listType);

for (Map<String, Object> json : list) {
    for (String key : json.keySet()) {
        System.out.println(key + ":" + json.get(key));
    }
    System.out.println("===========");
}