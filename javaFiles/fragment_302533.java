JsonNode kundeNode = Json.toJson(kunde);
JsonNode rechkopfNode = Json.toJson(rechkopf);

ObjectNode json = Json.newObject();

json.put("kunde",kundeNode);
json.put("rechKopf",rechkopfNode);

return ok(json);