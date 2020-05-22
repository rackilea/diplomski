//   https://server.example.com/token server url example
try {
  TokenResponse response =
      new AuthorizationCodeTokenRequest(new NetHttpTransport(), new JacksonFactory(),
          new GenericUrl("here is the server url "), "here write your code")
          .setRedirectUri("here write the redirectUrl")
          .set("client_id","here write your client_id")
          .set("client_secret","here write your client_secret")
          .set("Other else need","Other else need")
          .execute();
  System.out.println("Access token: " + response.getAccessToken());
} catch (TokenResponseException e) {
  if (e.getDetails() != null) {
    System.err.println("Error: " + e.getDetails().getError());
    if (e.getDetails().getErrorDescription() != null) {
      System.err.println(e.getDetails().getErrorDescription());
    }
    if (e.getDetails().getErrorUri() != null) {
      System.err.println(e.getDetails().getErrorUri());
    }
  } else {
    System.err.println(e.getMessage());
  }
}