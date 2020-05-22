public Credential refreshAccessToken(String refreshToken, String clientId, String clientSecret) throws IOException {
try {
  TokenResponse response =
  new GoogleRefreshTokenRequest(new NetHttpTransport(), new JacksonFactory(),
      refreshToken, clientId, clientSecret).execute();
  System.out.println("Access token: " + response.getAccessToken());
  return buildEmpty().setAccessToken(response.getAccessToken());
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