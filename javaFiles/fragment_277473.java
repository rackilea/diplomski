@Bean
public FreeMarkerViewResolver freeMarkerViewResolver() {
    FreeMarkerViewResolver fvr = new FreeMarkerViewResolver();
    fvr.setViewClass(CusotmFreeMarkerView.class);
    ...
}