@Bean(name = "countries")
public Wsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
    MyWsdl11Definition wsdl11Definition = new MyWsdl11Definition();
    wsdl11Definition.setPortTypeName("CountriesPort");
    wsdl11Definition.setLocationUri("/ws");
    wsdl11Definition.setRequestSuffix("");
    wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
    wsdl11Definition.setSchema(countriesSchema);
    return wsdl11Definition;
}