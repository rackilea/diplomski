InputStream inputStream = filePost.getResponseBodyAsStream();
FileInputStream outputStream = new FileInputStream(destination);

// Per your question the buffer is set to 1 byte, but you should be able to use
// a larger buffer.
byte[] buffer = new byte[1]; 
int bytesRead;
while ((bytesRead = input.read(buffer)) != -1)
{
    outputStream.write(buffer, 0, bytesRead);
}

outputStream.close();
inputStream.close();