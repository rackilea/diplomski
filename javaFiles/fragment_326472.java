/**
 * Copys the input streams in order to output stream and retains json array
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
    long channelSize = outputStream.getChannel().size();
    // truncate file to remove trailing ']'
    outputStream.getChannel().truncate(channelSize - 1);
    // check to see if array was empty (2 = [])
    if (channelSize > 2) {
        // add comma between json objects
        outputStream.write(COMMA);
    }
    // skip '['
    inputStreamB.skip(1);
    // and copy rest of streams normal
    copyStream(inputStreamB, outputStream);
    long newChannelSize = outputStream.getChannel().size();
    // check if we haven't just added a empty array
    if(newChannelSize - channelSize < 2){
        // if so truncate to remove comma 
        outputStream.getChannel().truncate(channelSize - 1);
        outputStream.write(CLOSE_SQUARE_BRACKET);
    }
}