@Bean
@ConditionalOnMissingBean(RequestContextFilter.class)
public RequestContextFilter requestContextFilter() {
  return new RequestContextFilter();
}

@Bean
public FilterRegistrationBean requestContextFilterChainRegistration(
  @Qualifier("requestContextFilter") Filter securityFilter) {

  FilterRegistrationBean registration = 
    new FilterRegistrationBean(securityFilter);

  registration.setName("requestContextFilter");

  // note : must to be following order of springSessionRepositoryFilter
  registration.setOrder(SessionRepositoryFilter.DEFAULT_ORDER + 1);

  return registration;
}