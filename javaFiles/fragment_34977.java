@Bean
public LiteDeviceDelegatingViewResolver liteDeviceAwareViewResolver() {
    InternalResourceViewResolver delegate = 
            new InternalResourceViewResolver();
    delegate.setPrefix("/WEB-INF/views/");
    delegate.setSuffix(".jsp");
    LiteDeviceDelegatingViewResolver resolver = 
            new LiteDeviceDelegatingViewResolver(delegate);
    resolver.setMobilePrefix("mobile/");
    resolver.setTabletPrefix("tablet/");
    return resolver;
}