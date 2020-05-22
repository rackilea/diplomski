@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/static/**").addResourceLocations("classpath:META-INF/resources/static/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:META-INF/resources/webjars/");
    registry.addResourceHandler("/**").addResourceLocations("classpath:META-INF/");
}