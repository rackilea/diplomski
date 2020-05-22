private static ApiEndpointInterface prepareService() {

    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(BASE_URL)
            .setLogLevel(RestAdapter.LogLevel.FULL);
            .build();

    ApiEndpointInterface apiService =
            restAdapter.create(ApiEndpointInterface.class);

    return apiService;
}