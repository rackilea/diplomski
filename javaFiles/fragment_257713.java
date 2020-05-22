@Bean
public Wss4jSecurityInterceptor securityInterceptor() {
  Wss4jSecurityInterceptor interceptor = new Wss4jSecurityInterceptor();
  interceptor.setSecurementUsername("username");
  interceptor.setSecurementPassword("password");
  interceptor.setSecurementUsernameTokenNonce(true);
  interceptor.setSecurementActions("UsernameToken Timestamp");
  return interceptor;
}