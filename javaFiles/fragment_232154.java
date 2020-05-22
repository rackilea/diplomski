byte[] data = new byte[bytesToRead];
int offset = 0;
int bytesRead;
while ((bytesRead = stream.read(data, offset, data.length - offset)) > -1) {
    offset += bytesRead;
    // Update progress indicator
}