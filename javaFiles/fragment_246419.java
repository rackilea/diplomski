JsonObject obj = new JsonObject();
JsonArray array = new JsonArray();
array.add(new JsonPrimitive("one"));
array.add(new JsonPrimitive("two"));
array.add(new JsonPrimitive("three"));
obj.add("main", array);