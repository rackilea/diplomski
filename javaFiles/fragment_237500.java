@Configuration
@ComponentScan(basePackages="org.bk.webtestuuid")
public class WebConfiguration extends WebMvcConfigurationSupport{

    @Bean
    public PathMatcher pathMatcher(){
        return new CaseInsensitivePathMatcher();
    }
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        handlerMapping.setPathMatcher(pathMatcher());
        return handlerMapping;
    }
}