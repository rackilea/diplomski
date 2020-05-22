// Place where I'd like to get more entries.
JsonArray oldArray = jsonReader.readArray();
// new array builder
JsonArrayBuilder builder = Json.createArrayBuilder();
// copy over old values
for (JsonValue value : oldArray) {
    builder.add(value);
}
// add new values
builder.add("new string value");
// done
JsonArray newArray = builder.build();