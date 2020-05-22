public class ClasspathResourceResolver implements LSResourceResolver {

    @Override
    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
        InputStream resource = getSystemResourceAsStream(systemId);
        return new DOMInputImpl(publicId, systemId, baseURI, resource, null);
    }
}