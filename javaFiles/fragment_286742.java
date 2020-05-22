OutputStream os = new FileOutputStream(filePath, false);

byte[] buffer = new byte[1024];
int bytesRead;
//read from is to buffer
try {
    DownloadStream stream = resource.getStream();
    while(true)
    {
         bytesRead = stream.getStream().read(buffer);
         if(bytesRead == -1)
             break;

         os.write(buffer, 0, bytesRead);
    }
    os.flush();
    os.close();
} catch (IOException e) {
    e.printStackTrace();
}