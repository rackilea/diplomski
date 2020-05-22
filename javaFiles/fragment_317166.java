JsonObject newChange = new JsonObject();
newChange.addProperty("Changeset", csRef);
newChange.addProperty("PathAndFilename", "a/b/c");  

CreateRequest cRequest = new CreateRequest("change", newChange);
CreateResponse cResponse = restApi.create(cRequest);
String cRef = cResponse.getObject().get("_ref").getAsString();
System.out.println(String.format("Created %s", cRef));