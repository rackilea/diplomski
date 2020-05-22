JsonObject root = new JsonObject();
    JsonObject c0 = new JsonObject();
    JsonObject c1 = new JsonObject();

    root.add("0", c0);
    root.add("1", c1);

    c0.add("Name", new JsonPrimitive("ABC"));
    c0.add("Email", new JsonPrimitive("abc@gmail.com"));
    c1.add("Name", new JsonPrimitive("xyz"));
    c1.add("Email", new JsonPrimitive("xyz@gmail.com"));
    System.out.println(new Gson().toJson(root));