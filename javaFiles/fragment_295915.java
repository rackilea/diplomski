@Bean
@ConditionalOnMissingBean(RequestContextFilter.class)
public RequestContextFilter requestContextFilter() {

  return new RequestContextFilter();
}

@Bean
public FilterRegistrationBean requestContextFilterChainRegistration(
  @Qualifier("requestContextFilter") Filter securityFilter) {

  FilterRegistrationBean registration = new FilterRegistrationBean(securityFilter);
  registration.setName("requestContextFilter");

  // note : must previous order of oAuth2ClientContextFilter
  registration.setOrder(SessionRepositoryFilter.DEFAULT_ORDER + 1);

  return registration;
}

@Bean
public FilterRegistrationBean sessionRepositoryFilterRegistration(
  SessionRepositoryFilter sessionRepositoryFilter) {

  FilterRegistrationBean registration = new FilterRegistrationBean(sessionRepositoryFilter);
  registration.setName("springSessionRepositoryFilter");

  // note : must following order of oAuth2ClientContextFilter
  registration.setOrder(Integer.MAX_VALUE - 1);

  return registration;
}