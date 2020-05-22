@Configuration
    @EnableWebMvc
    public class WebConfiguration extends WebMvcConfigurerAdapter {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new DetailInterceptor()).addPathPatterns("/activities/{activityId}");
            registry.addInterceptor(new CollectionInterceptor()).addPathPatterns("/activities");
        }
    }