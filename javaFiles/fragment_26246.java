public class SaajSoapMessageValidatorFactory extends SaajSoapMessageFactory {

    @Override
    public SaajSoapMessage createWebServiceMessage(InputStream inputStream) throws IOException {
        InputStream original;

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IOUtils.copy(inputStream, baos);

            original = new ByteArrayInputStream(baos.toByteArray());
            InputStream validate = new ByteArrayInputStream(baos.toByteArray());

            try {
                ValidatorResources validator = new XmlValidatorResources(validate);
                validator.process();
            } catch (Exception parseException) {
                throw new InvalidXmlException("Could not parse XML", parseException);
            } finally {
                IOUtils.closeQuietly(validate);
            }
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        return super.createWebServiceMessage(original);
    }
}



public class XmlValidatorResources extends ValidatorResources {

    private static final long serialVersionUID = 1L;

    public XmlValidatorResources(InputStream in) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.push(this);
        digester.parse(in);
    }

}