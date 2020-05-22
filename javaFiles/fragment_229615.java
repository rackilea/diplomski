// Query for Story to associate with Defect
String storyFormattedID = "US20142";
QueryRequest storyRequest = new QueryRequest("HierarchicalRequirement");
storyRequest.setFetch(new Fetch("FormattedID","Name","Changesets"));
storyRequest.setQueryFilter(new QueryFilter("FormattedID", "=", storyFormattedID));
QueryResponse storyQueryResponse = restApi.query(storyRequest);
JsonObject storyJsonObject = storyQueryResponse.getResults().get(0).getAsJsonObject();
String storyRef = storyJsonObject.get("_ref").toString();

JsonObject newDefect = new JsonObject();
newDefect.addProperty("Name", "Test Defect");
newDefect.addProperty("Priority", "High Attention");
newDefect.addProperty("Severity", "Major Problem");
newDefect.addProperty("Requirement", storyRef);

CreateRequest storyCreateRequest = new CreateRequest("defect", newDefect);
CreateResponse storyCreateResponse = restApi.create(storyCreateRequest);