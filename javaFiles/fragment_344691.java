@Autowired
GenericApplicationContext context;

private void loadBeans(String beansXml) {
    XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
    xmlReader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_XSD);
    xmlReader.loadBeanDefinitions(new InputSource(new StringReader(beansXml)));
}