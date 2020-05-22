@PostConstruct
  public void init() {
    restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(new ResponseErrorHandler() {

      @Override
      public boolean hasError(ClientHttpResponse response) throws IOException {
        return false;
      }

      @Override
      public void handleError(ClientHttpResponse response) throws IOException {
        // Response is forwarded to the client without any error handling.
      }
    });


  }