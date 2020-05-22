public void retrieveJsonString() {

  // RestClient setup
  RestClient restClient =
    RestClient.create().host(this.host).path(this.path).queryParam("schema", this.schema)
        .queryParam("uri", "/contactsform").method("GET");


  MyCustomStringInputConverter converter = new MyCustomStringInputConverter();

  // GluonObservableObject setup
  GluonObservableObject<String> godp =
    DataProvider.retrieveObject(restClient.createObjectDataReader(converter));

  // Add a listener to the GluonObservableObject
  godp.stateProperty().addListener(new InvalidationListener() {
    @Override
    public void invalidated(Observable arg0) {
      if (godp.getState().equals(ConnectState.SUCCEEDED)) {
        response.bind(godp.asString()); 
      } else if (godp.getState().equals(ConnectState.FAILED)) {
        exceptionMsg.set(godp.getException().getMessage());
      }
      }
  });

}