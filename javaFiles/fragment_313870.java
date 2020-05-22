int bytesRead = 0;
while (true) {
    int n = is.read(byteArray, bytesRead, byteArray.length);
    if (n == -1) break;
    bytesRead += n;
}