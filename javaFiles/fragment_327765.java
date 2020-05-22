@Constraints.Required()
private String recapatcha;

private List<ValidationError> validate() {
  ...
  final JsonNode response = WS.url("recaptcha-verify-endpoint").setQueryParameter("secret", "your secret").setQueryParameter("response", this.recaptcha).post("").get(5000L).asJson();

  if(!response.get("success").booleanValue() && response.has("error-codes"){
    //TODO: Add error according to recaptcha error code
  }
  ...
}