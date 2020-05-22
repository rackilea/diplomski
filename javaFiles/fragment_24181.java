@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

@Autowired
private MyHandlerInterceptor interceptor;

@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptor).addPathPatterns("/**");
}
}