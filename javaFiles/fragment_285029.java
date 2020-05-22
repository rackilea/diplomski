// This part can be in a static initializer, with `jaxbContext` and `schema` as static variables.
JAXBContext jaxbContext = JAXBContext.newInstance("package1:package2");
try (InputStream xsdStream1 = EraMarshallingService.class.getResourceAsStream("/a.xsd");
        InputStream xsdStream2 = EraMarshallingService.class.getResourceAsStream("/b.xsd");
        InputStream xsdStream3 = EraMarshallingService.class.getResourceAsStream("/c.xsd");) {
    SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = sf.newSchema(new Source[] { new StreamSource(xsdStream1), new StreamSource(xsdStream2),
                new StreamSource(xsdStream3));
}

// This part should be done for each document.
Marshaller marshaller = getJaxbContext().createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
marshaller.setSchema(schema);
marshaller.marshal(jaxbRootElement, whereTheOutputIsGoing);