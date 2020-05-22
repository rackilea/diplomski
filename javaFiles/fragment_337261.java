@Bean
public MyResourceBundleMessageSource messageSource() throws IOException {
    MyResourceBundleMessageSource messageSource = new MyResourceBundleMessageSource();
    messageSource.setResources(new PathMatchingResourcePatternResolver().getResources("classpath*:messages/*.properties"));
    return messageSource;
}