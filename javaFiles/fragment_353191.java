@Configuration
public class CamelContextConfig implements CamelContextConfiguration {
    @Override
    public void beforeApplicationStart(CamelContext camelContext) {

    }

    @Override
    public void afterApplicationStart(CamelContext camelContext) {
        camelContext.getGlobalOptions().put(JacksonConstants.ENABLE_TYPE_CONVERTER, "true");
        camelContext.getGlobalOptions().put(JacksonConstants.TYPE_CONVERTER_TO_POJO, "true");
    }
}