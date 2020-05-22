InputStream in = …;
byte[] buffer = new byte[512];
int read = -1;
while ((read = stream.read(buffer)) != -1) {
    // process contents of buffer
}