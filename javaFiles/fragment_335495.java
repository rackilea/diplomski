class CustomErrorHandler implements ErrorHandler {

    @Override
    public void warning(SAXParseException exc) {
        throw exc;
    }

    @Override
    public void error(SAXParseException exc) throws SAXParseException {
        if (exc.getMessage().equals("cvc-complex-type.2.4.c: The matching wildcard is strict, but no declaration can be found for element 'b:person'."))
            ; // suppress
        else
            throw exc;
    }

    @Override
    public void fatalError(SAXParseException exc) throws SAXParseException {
        throw exc;
    }
}

public class FooMain {


    public static void main (String args[]) throws JAXBException, FileNotFoundException, SAXException, IOException  {
        String xmlFileName = "ab.xml";
        final Schema SCHEMA_A = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("A.xsd"));
        SAXSource source = new SAXSource(new InputSource(xmlFileName));
        Validator validator = SCHEMA_A.newValidator();
        validator.setErrorHandler(new CustomErrorHandler());
        validator.validate(source);
        JAXBContext jc = JAXBContext.newInstance("example.a");
        Unmarshaller u = jc.createUnmarshaller();
        // u.setSchema(SCHEMA_A); // not possible to partially validate using this method
        JAXBElement<SomeType> element = (JAXBElement<SomeType>) u.unmarshal( new FileInputStream( xmlFileName ) );
    }
}