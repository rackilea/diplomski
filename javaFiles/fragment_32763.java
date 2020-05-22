GetRequest getRequest = new GetRequest("/subscription");
getRequest.setFetch("Workspaces", "Name", "State");
GetResponse getResponse = restApi.get(getRequest);

JsonObject subscription = getResponse.getSubscription();
JsonArray workspaces = subscription.getAsJsonArray("Workspaces");
for (JsonElement w : workspaces) {
    JsonObject workspace = w.getAsJsonObject();
    System.out.println(String.format("\t%s: %s",
        workspace.get("Name").getAsString(),
        workspace.get("State").getAsString());
}