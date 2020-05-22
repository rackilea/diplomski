JsonObject i1 = new JsonObject();
JsonObject i0 = new JsonObject();
i1.add("i2", gson.toJsonTree(object));
i0.add("i1", i1);
String results = gson.toJson(i0);
System.out.println("results=" + results);