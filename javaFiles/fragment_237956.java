// Get the response header `location` from 1st step REST API
OkHttpClient client = new OkHttpClient();
String url = String.format("https://management.azure.com/subscriptions/%s/resourceGroups/%s/providers/Microsoft.Network/applicationGateways/%s/backendhealth?api-version=%s", subscriptionId, resourceGroupName, appGatewayName, apiVersion);
MediaType JSON = MediaType.parse("application/json; charset=utf-8");
RequestBody body = RequestBody.create(JSON, "");
Request request = new Request.Builder().url(url).header("Authorization", "Bearer "+accessToken).post(body).build();
Response response = client.newCall(request).execute();
String location = response.header("Location");
System.out.println(location);