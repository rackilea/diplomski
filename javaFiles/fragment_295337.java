/*
 * (non-Javadoc)
 * 
 * @see javax.xml.stream.XMLStreamWriter#writeCharacters(java.lang.String)
 */
@Override
public void writeCharacters(String text) throws XMLStreamException {
    if (this.tokenAsString.equals(text)) {
        writeCharacters(text.toCharArray(), 0, text.length());
    } else {
        xmlStreamWriter.writeCharacters(text);
    }
}

/*
 * (non-Javadoc)
 * 
 * @see javax.xml.stream.XMLStreamWriter#writeCharacters(char[], int, int)
 */
@Override
public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
    char[] range = Arrays.copyOfRange(text, 0, len);
    if (Arrays.equals(range, token)) {
        LOGGER.debug("Found replace token. Start streaming binary data.");
        // force the XMLStreamWriter to close the start tag.
        xmlStreamWriter.writeCharacters("");
        try {
            // flush the content of the streams.
            xmlStreamWriter.flush();
            outputStream.flush();
            // do base64 encoding.
            OutputStream wrap = Base64.getMimeEncoder().wrap(outputStream);
            this.binaryData.writeTo(wrap);
        } catch (IOException e) {
            throw new XMLStreamException(e);
        } finally {
            try {
                // flush the output stream
                outputStream.flush();
            } catch (IOException e) {
                throw new XMLStreamException(e);
            }
        }
        LOGGER.debug("Successfully inserted binary data.");
    } else {
        xmlStreamWriter.writeCharacters(text, start, len);
    }
}