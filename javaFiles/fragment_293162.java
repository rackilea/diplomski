@Autowired  
AuthRequestService authRequestService;

[...]

FilterRegistrationBean<SAPServiceFilter> filterRegBean = new FilterRegistrationBean<>();
filterRegBean.setFilter(new SAPServiceFilter(authRequestService));