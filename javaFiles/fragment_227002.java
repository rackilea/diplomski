void copyStreamToFile(InputStream in, File outputFile, boolean doDeleteOnExit) {
    //Clean up file after VM exit, if needed.
    if(doDeleteOnExit)
        outputFile.deleteOnExit();
    FileOutputStream outputStream = new FileOutputStream(outputFile);
    ReadableByteChannel inputChannel = Channels.newChannel(in);
    WritableByteChannel outputChannel = Channels.newChannel(outputStream);
    ChannelTools.fastChannelCopy(inputChannel, outputChannel);
    inputChannel.close();
    outputChannel.close()
}