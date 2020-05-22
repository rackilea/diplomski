@Bean
public FilterRegistrationBean logout() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    LogoutFilter logoutFilter = new LogoutFilter();
    logoutFilter.setRedirectUrl("/login.jsp");
    filterRegistrationBean.setFilter(logoutFilter);
    filterRegistrationBean.addUrlPatterns("/logout.htm");
    return filterRegistrationBean;
}