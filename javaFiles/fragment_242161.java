RequestInterceptor requestInterceptor = new RequestInterceptor() {
  @Override
  public void intercept(RequestFacade request) {
    request.addHeader("User-Agent", "Retrofit-Sample-App");
  }
};

RestAdapter restAdapter = new RestAdapter.Builder()
.setEndpoint("https://api.github.com")
.setRequestInterceptor(requestInterceptor)
.build();