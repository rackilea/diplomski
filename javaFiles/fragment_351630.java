@org.springframework.context.annotation.Bean
public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
    PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
    ppc.setIgnoreResourceNotFound(true);
    return ppc;
}