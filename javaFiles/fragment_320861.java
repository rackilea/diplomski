int remainingBytes = expectedBytes;
while (remainingBytes > 0) {
    int bytesRead = in.read(buffer, 0, Math.min(buffer.length, remainingBytes));
    if (bytesRead < 0) {
        throw new IOException("Unexpected end of data");
    }
    baos.write(buffer, 0, bytesRead);
    remainingBytes -= bytesRead;
}