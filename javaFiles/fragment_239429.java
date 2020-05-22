byte[] buffer = new byte[1024 /* or some other number */];
int numRead;

while((numRead = inputStream.read(buffer)) > 0) {
    outputStream.write(buffer, 0, numRead);
}