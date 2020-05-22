public RestAdapter getHostAdapter(String baseHost){
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(baseHost)
            .setRequestInterceptor(requestInterceptor)
            .build();

    return restAdapter;
}