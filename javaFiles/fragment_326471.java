/**
 * Copys the input streams in order to the output stream and retains json array
 * format
 * 
 * @param inputStreamA
 * @param inputStreamB
 * @param outputStream
 * @throws IOException
 */
private void copyStreamsToOutput(InputStream inputStreamA, InputStream inputStreamB,
        FileOutputStream outputStream) throws IOException {
    copyStream(inputStreamA, outputStream);
    // truncate file to remove trailing ']'
    outputStream.getChannel().truncate(outputStream.getChannel().size() - 1);
    // add comma between json objects
    outputStream.write(COMMA);
    // skip '['
    inputStreamB.skip(1);
    // and copy rest of streamas normal
    copyStream(inputStreamB, outputStream);
}