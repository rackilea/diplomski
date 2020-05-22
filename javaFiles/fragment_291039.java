@Bean
public FilterRegistrationBean remoteAddressFilter() {

    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    RemoteAddrFilter filter = new RemoteAddrFilter();

    filter.setAllow("192.168.0.2");
    filter.setDenyStatus(404);

    filterRegistrationBean.setFilter(filter);
    filterRegistrationBean.addUrlPatterns("/*");

    return filterRegistrationBean;

}