@Bean
public FilterRegistrationBean jwtvFilterRegBean() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(jwtv());
    filterRegistrationBean.setEnabled(false);
    return filterRegistrationBean;
}