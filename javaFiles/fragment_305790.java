@Bean 
public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver cr = new CommonsMultipartResolver();
    cr.setDefaultEncoding("UTF-8");
    cr.setMaxUploadSize(26214400);
    return cr;
}