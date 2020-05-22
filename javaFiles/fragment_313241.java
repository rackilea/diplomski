byte[] outputByte = new byte[4096];
int readLen = -1;

while ( (readLen = is.read(outputByte)) != -1) {
    outA.write(outputByte, 0, readLen);
}