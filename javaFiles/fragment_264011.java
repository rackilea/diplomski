@Bean
public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
    SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
    mapping.setUrlMap(Collections.singletonMap(odataUrlPath, "odataRequestHandler"); 
    return mapping;
}