int n;
while ((n = bis.read(byteArray, 0, byteArray.length)) != -1) {
    // Send the chunk of n bytes
    outToClient.write(byteArray, 0, n);
}
bis.close();
outToClient.close();