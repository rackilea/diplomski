/**
 * Constructor.
 * 
 * @param outputStream
 *            {@link #outputStream}
 * @param binaryData
 *            {@link #binaryData}
 * @param token
 *            the search token.
 * @throws XMLStreamException
 *             In case the XMLStreamWriter cannot be constructed.
 */
private XMLStreamWriterWrapper(OutputStream outputStream, DataHandler binaryData, String token) throws XMLStreamException {
    this.xmlStreamWriter = XMLOutputFactory.newFactory().createXMLStreamWriter(outputStream);

    // ensure the OutputStream is buffered. otherwise encoding of large data
    // takes hours.
    if (outputStream instanceof BufferedOutputStream) {
        this.outputStream = outputStream;
    } else {
        this.outputStream = new BufferedOutputStream(outputStream);
    }
    this.binaryData = binaryData;
    // calculate the token.
    byte[] encode = Base64.getEncoder().encode(token.getBytes(Charset.forName("UTF-8")));
    this.tokenAsString = new String(encode, Charset.forName("UTF-8"));
    this.token = this.tokenAsString.toCharArray();
}

/**
 * Factory method to create the {@link XMLStreamWriterWrapper}.
 * 
 * @param outputStream
 *            The OutputStream where to marshal the xml to.
 * @param binaryData
 *            The binary data which shall be streamed to the xml.
 * @param token
 *            The token which akts as placeholder for the binary data.
 * @return The {@link XMLStreamWriterWrapper}
 * @throws XMLStreamException
 *             In case the XMLStreamWriter could not be constructed.
 */
public static XMLStreamWriterWrapper newInstance(OutputStream outputStream, DataHandler binaryData, String token) throws XMLStreamException {
    return new XMLStreamWriterWrapper(outputStream, binaryData, token);
}