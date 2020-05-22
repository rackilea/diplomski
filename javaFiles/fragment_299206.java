@Configuration
@EnableWebMvc
public class Api extends WebMvcConfigurationSupport {

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping mapping = super.requestMappingHandlerMapping();
        mapping.setUseSuffixPatternMatch(false);
        return mapping;
    }

}