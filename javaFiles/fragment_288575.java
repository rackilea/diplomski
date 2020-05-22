@Configuration
public class WebApiConfiguration extends WebMvcConfigurationSupport {
    ...

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserInfoResolver());
    }

    ...
}