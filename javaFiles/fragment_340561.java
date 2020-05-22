SwiftApi swiftApi = ContextBuilder.newBuilder(PROVIDER)
           .credentials("{username}", "{apiKey}")
           .buildApi(SwiftApi.class);

// Access the accountApi
AccountApi accountApi = swiftApi.getAccountApiForRegion("{regionId");
accountApi.updateTemporaryUrlKey("{newKey}");

// Access the key
String tempUrlKey;
if (accountApi.getTemporaryUrlKey().isPresent()) {
   tempUrlKey = accountApi.get().getTemporaryUrlKey().get();
}