@Bean
public CommonsMultipartResolver multipartResolver(){
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    resolver.setMaxUploadSize(5242880); // set the size limit
    return resolver;
}