@Bean(name="multipartResolver")
public CommonsMultipartResolver fileResolver() {
    CommonsMultipartResolver cr = new CommonsMultipartResolver();
    cr.setDefaultEncoding("UTF-8");
    cr.setMaxUploadSize(26214400);
    return cr;
}