public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ValidModifyingVerbMethodArgumentResolver(true));
    }
}