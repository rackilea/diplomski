final Gson gson = new Gson();
final Foo[] foos = new Foo[] {};

final JsonElement elem = gson.toJsonTree(foos);
final JsonObject jsonObj = new JsonObject();
jsonObj.add("foo", elem);
System.out.println(jsonObj.toString());