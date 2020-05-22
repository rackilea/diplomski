@Configuration
public static class WebContextConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(kebabCaseProcessor());
    }

    @Bean
    protected KebabCaseProcessor kebabCaseProcessor() {
        return new KebabCaseProcessor(true);
    }
}