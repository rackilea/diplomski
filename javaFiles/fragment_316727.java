@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/client/**")
        .addResourceLocations("/client/");
}