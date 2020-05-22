@Override
public SaajSoapMessage createWebServiceMessage(InputStream inputStream) throws IOException {
    MimeHeaders mimeHeaders = parseMimeHeaders(inputStream);
    try {
        inputStream = checkForUtf8ByteOrderMark(inputStream);
        SOAPMessage saajMessage = null;

        if (mimeHeaders.getHeader(HttpHeaders.CONTENT_TYPE)[0].contains(MimeTypeUtils.TEXT_XML_VALUE)) {
            saajMessage = messageFactory11.createMessage(mimeHeaders, inputStream);
        } else {
            saajMessage = messageFactory12.createMessage(mimeHeaders, inputStream);
        }
...snip