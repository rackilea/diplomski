@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean(name = "holiday-spring")
    public DefaultWsdl11Definition wsdl11DefinitionOne(@Qualifier("holiday-spring-schema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("HumanResource");
        wsdl11Definition.setLocationUri("/holidaySpringService/");
        wsdl11Definition.setTargetNamespace("http://mycompany.com/hr/definitions");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean(name = "holiday-winter")
    public DefaultWsdl11Definition wsdl11DefinitionTwo(@Qualifier("holiday-winter-schema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("HumanResource");
        wsdl11Definition.setLocationUri("/holidayWinterService/");
        wsdl11Definition.setTargetNamespace("http://mycompany.com/hr/definitions");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

}