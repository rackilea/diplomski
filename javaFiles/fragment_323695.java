/**
 * For loading an XML document from specified input stream, which must have the requisite DTD URI.
 * @see java.util.prefs.XmlSupport.Resolver
 */
private static class Resolver implements EntityResolver {
    @Override
    public InputSource resolveEntity(String pid, String sid)
        throws SAXException {
        if (sid.equals(PREFS_DTD_URI)) {
            InputSource is;
            is = new InputSource(new StringReader(PREFS_DTD));
            is.setSystemId(PREFS_DTD_URI);
            return is;
        }
        throw new SAXException("Invalid system identifier: " + sid);
    }
}