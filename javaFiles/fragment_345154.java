@Configuration
public class EnableUriMatrixVariableSupport extends WebMvcConfigurationSupport {

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping hm = super.requestMappingHandlerMapping();
        hm.setRemoveSemicolonContent(false);
        return hm;
    }
}