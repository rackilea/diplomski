public InputSource resolveEntity(final String publicId, final String systemId) throws SAXException {
    if ("xhtml11-flat.dtd".equals(systemId)) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputSource is = new InputSource();
        is.setSystemId(systemId);
        is.setByteStream(cl.getResourceAsStream("/com/example/dtd/xhtml11-flat.dtd"));
        return is;
    } else {
        return null;
    }
}