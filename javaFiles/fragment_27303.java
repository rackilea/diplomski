@EnableWs
@Configuration
@ComponentScan(value = "com.ws")
public class SoapServiceConfiguration extends WsConfigurerAdapter {


    @Bean
    public DefaultWsdl11Definition country(XsdSchema countriesSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(countriesSchema);

        definition.setPortTypeName("Country");
        definition.setLocationUri("http://wstest/uri");
        definition.setTargetNamespace("http://wstest");

        return definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        System.out.println("CONFIG");

        return new SimpleXsdSchema(new ClassPathResource("country.xsd"));
    }
}