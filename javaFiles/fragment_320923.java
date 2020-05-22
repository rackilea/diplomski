// Code code = new Code(...);
JsonDocument doc = bucket.get("ID");
JsonArray curAddlCodes = doc.content().getArray("additionalCodes");
JsonObject newCode = JsonObject.create()
    .put("code", code.code)
    .put("type", code.type)
    .put("dateTime", code.dateTime.toEpochSecond());
curAddlCodes.add(newCode);
doc = bucket.replace(doc);