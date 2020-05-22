long MAX_FILE_SIZE = 512;

try(RandomAccessFile file = new RandomAccessFile("Path to inputfile", "rw"))
{
    long fileSize = file.length();

    long readStartPosition = fileSize - MAX_FILE_SIZE;
    if(readStartPosition < 0)
    {
        return;
    }

    long writePosition = 0;
    byte[] buffer = new byte[1024];

    file.seek(readStartPosition);
    for(int bytesRead = file.read(buffer); bytesRead != -1; bytesRead = file.read(buffer))
    {
        long currentPosition = file.getFilePointer();

        file.seek(writePosition);
        file.write(buffer, 0, bytesRead);

        writePosition += bytesRead;

        file.seek(currentPosition);
    }

    long newSize = file.length() - readStartPosition;
    file.setLength(newSize);
}
catch(Throwable t)
{
    System.out.println(t);;
}