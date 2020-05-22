public Document parse(InputStream is)
    throws SAXException, IOException {
    if (is == null) {
        throw new IllegalArgumentException("InputStream cannot be null");
    }

    InputSource in = new InputSource(is);
    return parse(in);
}