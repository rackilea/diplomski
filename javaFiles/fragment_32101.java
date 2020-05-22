long MAX_FILE_SIZE = 512;

try(RandomAccessFile file = new RandomAccessFile("Path to inputfile", "r"))
{
    long fileSize = file.length();

    long readStartPosition = fileSize - MAX_FILE_SIZE;
    if(readStartPosition < 0)
    {
        readStartPosition = 0;
    }

    file.seek(readStartPosition);

    try(OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("Path to outputfile")))
    {
        byte[] buffer = new byte[1024];
        for(int bytesRead = file.read(buffer); bytesRead != -1; bytesRead = file.read(buffer))
        {
            outputStream.write(buffer, 0, bytesRead);
        }
    }
}
catch(Throwable t)
{
    System.out.println(t);;
}