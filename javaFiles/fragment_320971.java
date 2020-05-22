@Configuration
public class ExtendedWebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        ExtendedRequestMappingHandlerMapping handlerMapping = new ExtendedRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }

    @Override @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = super.requestMappingHandlerAdapter();
        adapter.setIgnoreDefaultModelOnRedirect(true);
        return adapter;
    }

}