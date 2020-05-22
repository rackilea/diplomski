@Api(clientIds = {Ids.WEB_CLIENT_ID})
public class MyEndpoint {
  public getFoo(User user) throws OAuthRequestException {
    if (user != null) {
      // do something with user
    } else {
      throw new OAuthRequestException("Invalid user.");
    }
  }
}