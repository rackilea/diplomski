static void refreshAccessToken() throws IOException {
try {
  TokenResponse response =
      new GoogleRefreshTokenRequest(new NetHttpTransport(), new JacksonFactory(),
          "tGzv3JOkF0XG5Qx2TlKWIA", "s6BhdRkqt3", "7Fjfp0ZBr1KtDRbnfVdmIw").execute();
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