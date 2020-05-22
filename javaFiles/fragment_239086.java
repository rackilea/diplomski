class WebServiceValidator implements Validator {
  private final WebServiceFacade facade;

  public WebServiceValidator(WebServiceFacade facade) {
    this.facade = facade;
  }

  public ValidationResponse validate(Address address) {
    WebService wsResponse = webservice.validate(address);
    ValidationResponse reponse = proccessWsResponse(wsResponse);
    return response;
  }
}