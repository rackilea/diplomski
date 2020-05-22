@Bean
TokenProcessingFilter tokenProcessingFilter() {
  TokenProcessingFilter tokenProcessingFilter = new TokenProcessingFilter();
  tokenProcessingFilter.setAuthenticationManager(authenticationManager());
  return tokenProcessingFilter;
}