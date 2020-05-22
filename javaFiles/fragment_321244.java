@Component
public class WebServiceConfig extends ResourceConfig {

    public WebServiceConfig() {
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, "true");
    }
}