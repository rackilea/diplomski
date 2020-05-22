public void init() {
    XmlFactory factory = new XmlFactory(new InputFactoryImpl(),
            new CDataXmlOutputFactoryImpl());
    xmlMapper = new XmlMapper(factory);
    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
}