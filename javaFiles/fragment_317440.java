public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(deviceResolverHandlerInterceptor());
    registry.addInterceptor(sitePreferenceHandlerInterceptor());
    registry.addInterceptor(mySwitcher());
}

@Bean
public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
    return new DeviceResolverHandlerInterceptor();
}

@Bean
public SitePreferenceHandlerInterceptor sitePreferenceHandlerInterceptor() {
    return new SitePreferenceHandlerInterceptor();
}

@Bean
public MySwitcher mySwitcher() {
    return new MySwitcher();
}