@Configuration
public class SoapWebServiceConfig extends WsConfigurationSupport {

    //Wss4jSecurityCallbackImpl refers to an implementation of https://sites.google.com/site/ddmwsst/ws-security-impl/ws-security-with-usernametoken
    @Bean
    public CustomSmartEndpointInterceptor customSmartEndpointInterceptor() {
        CustomSmartEndpointInterceptor customSmartEndpointInterceptor = new CustomSmartEndpointInterceptor();
        customSmartEndpointInterceptor.setValidationActions("UsernameToken");
        customSmartEndpointInterceptor.setValidationCallbackHandler(new Wss4jSecurityCallbackImpl(login, pwd)); 
        return customSmartEndpointInterceptor;
    }

  [...]
}