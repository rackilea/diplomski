@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new WebRequestHandlerInterceptorAdapter(
                        new CustomerStateInterceptor()));
    }

}