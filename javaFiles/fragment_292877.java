@Bean
public CommonsMultipartResolver filterMultipartResolver() {
    return new CommonsMultipartResolver();
}

@Bean
@Order(0)
public MultipartFilter multipartFilter() {
    return new MultipartFilter();
}