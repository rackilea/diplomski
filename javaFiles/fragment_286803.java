javax.json.JsonArray value = javax.json.Json.createArrayBuilder()
     .add(javax.json.Json.createObjectBuilder()
             .add("type", "home")
             .add("number", "212 555-1234"))
     .add(javax.json.Json.createObjectBuilder()
             .add("type", "fax")
             .add("number", "646 555-4567"))
     .build();

for (javax.json.JsonValue jsonValue : value) {
    System.out.println(jsonValue);
}