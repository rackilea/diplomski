@Configuration
@EnableWebMvc
public class WebMvcContext extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableArgumentResolverhandler = new PageableHandlerMethodArgumentResolver(
                new CustomSortHandlerMethodArgumentResolver()); 

        argumentResolvers.add(handler);
    } 
}