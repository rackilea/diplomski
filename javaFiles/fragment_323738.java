public void setupContext(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
  this.oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
  oAuthConsumer.setTokenWithSecret(accessToken, accessTokenSecret);
  oAuthConsumer.setSigningStrategy(new AuthorizationHeaderSigningStrategy());
  HttpParameters parameters = new HttpParameters();
  parameters.put("realm", realmID);
  oAuthConsumer.setAdditionalParameters(parameters);
}