@Override
public void addInterceptors( InterceptorRegistry registry ) {
    registry.addInterceptor( new DeviceResolverHandlerInterceptor() );
    registry.addInterceptor( new SitePreferenceHandlerInterceptor() );
    registry.addInterceptor( new MySwitcher() );
}