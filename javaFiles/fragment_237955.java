String AUTHORITY = "https://login.windows.net/<tenantId>";
String clientId = "<client-id on management portal(old), or application-id on Azure new portal>";
String clientSecret = "<client-secret-key>";
String subscriptionId = "<subscriptionId>";
String resourceGroupName = "<resource-group-name>";
String appGatewayName = "<applicationgateway-name>";
String apiVersion = "2016-09-01";
// Getting access token
AuthenticationContext context = null;
AuthenticationResult result = null;
ExecutorService service = null;
service = Executors.newFixedThreadPool(1);
context = new AuthenticationContext(AUTHORITY, false, service);
ClientCredential credential = new ClientCredential(clientId, clientSecret);
Future<AuthenticationResult> future = context.acquireToken("https://management.azure.com/", credential, null);
result = future.get();
String accessToken = result.getAccessToken();
System.out.println(accessToken);