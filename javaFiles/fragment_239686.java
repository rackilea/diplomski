String strFileContents = "";
byte[] contents = new byte[1024];
int bytesRead = 0;

while (dataInputStream.available() != 0) {
    while ((bytesRead = bufferedInputStream.read(contents)) != -1) {
        strFileContents = new String(contents, 0, bytesRead, "ISO-8859-1");
    }
}