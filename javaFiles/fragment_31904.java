@Bean
public MessageSource messageSource() {
    ResourceBundleMessageSource source = new ResourceBundleMessageSource();
    source.setBasenames("classpath:messages/user/login/login",
                        "classpath:messages/user/user",
                        //external file (in utils-0.1.jar)
                        "classpath:messages/enums/enums");
    source.setDefaultEncoding("UTF-8");
    return source;
}