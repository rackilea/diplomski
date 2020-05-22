@Override
public void addResourceHandlers(ResourceHandlerRegistry registry){
    //you can add more resources here 
    registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
    registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
}