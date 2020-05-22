public class LoginBeanResponseDeserializer implements JsonDeserializer<LoginBeanResponse> {

  @Override
  public LoginBeanResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

    // Based on the structure you check if the data is valid or not
    // Example for the above defined structures:

    // Get JsonObject
    final JsonObject jsonObject = json.getAsJsonObject();
    if (jsonObject.has("error") {
      ErrorMessage errorMessage = new Gson().fromJson(jsonObject, ErrorMessage.class);
      return new LoginBeanResponse(null, errorMessage)
    } else {
      LoginBean loginBean = new Gson().fromJson(jsonObject, LoginBean.class):
      return new LoginBeanResponse(loginBean, null);
    }
  }
}