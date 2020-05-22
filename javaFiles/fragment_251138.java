@Bean
AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter() {

    AnnotationMethodHandlerAdapter bean = new AnnotationMethodHandlerAdapter()
    bean.setMessageConverters(Arrays.asList(new ByteArrayHttpMessageConverter()));
    return bean;
}