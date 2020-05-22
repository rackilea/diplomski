Gson googleJson = new Gson();
JsonObject data = googleJson.fromJson(request.getReader(), JsonObject.class);
System.out.println(data);
JsonArray jsonArr = new JsonArray();

for(Entry<String, JsonElement> entry : data.entrySet()) {
    jsonArr.add(data.get(entry.getKey()));
}

ArrayList jsonObjList = googleJson.fromJson(jsonArr, ArrayList.class);
for(int i = 0; i < jsonObjList.size(); i++) {
    System.out.println(jsonObjList.get(i));
}