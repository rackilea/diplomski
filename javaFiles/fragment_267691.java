public void parse(InputSource inputSource) throws SAXException, IOException
{
    try
    {
        XMLInputSource xmlInputSource = new XMLInputSource(inputSource.getPublicId(), inputSource.getSystemId(), null);
        xmlInputSource.setByteStream(inputSource.getByteStream());
        xmlInputSource.setCharacterStream(inputSource.getCharacterStream());
        xmlInputSource.setEncoding(inputSource.getEncoding());
        parse(xmlInputSource); <-- Original XNIException is thrown in here
    } catch (XMLParseException e) {
        ...
    } catch (XNIException e) { // <-- wrap XNI exceptions as SAX exceptions
        Exception ex = e.getException();
        if (ex == null) { throw new SAXException(e.getMessage()); }
        if (ex instanceof SAXException) { throw (SAXException) ex; }
        if (ex instanceof IOException) { throw (IOException) ex; }
        throw new SAXException(ex); // <-- Note: The original stack trace is lost here.
    }
}