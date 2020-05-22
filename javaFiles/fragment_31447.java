@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@Import(SoapSSLConfig.class)
public class CxfEndpointConfig
{
    ...
}