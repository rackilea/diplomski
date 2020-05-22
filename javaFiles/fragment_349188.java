@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean(name = "holiday")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("HumanResource");
        wsdl11Definition.setLocationUri("/holidayService/");
        wsdl11Definition.setTargetNamespace("http://mycompany.com/hr/definitions");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

}