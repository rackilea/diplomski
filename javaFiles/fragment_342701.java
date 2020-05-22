public void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
// Perform Authentication...
  User user = null;
  try {
  OAuthService oathService = OAuthServiceFactory.getOAuthService();
  user = oathService.getCurrentUser();
  System.out.println("Logged in! YAY!!!");
  } catch (OAuthRequestException e) {
     System.out.println("Authentication Failed! "+e);
  }
  ...