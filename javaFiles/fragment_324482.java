byte[] buffer = new byte[1024];
int bytesRead = 0;
while((bytesRead = inputStream.read(buffer)) != -1)
{
    Thread.sleep(5000);
    // then write to the target serial port.
}