String dirPath = ...;

ServerSocket serverSocket = ...;
Socket socket = serverSocket.accept();

BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
DataInputStream dis = new DataInputStream(bis);

int filesCount = dis.readInt();
File[] files = new File[filesCount];

for(int i = 0; i < filesCount; i++)
{
    long fileLength = dis.readLong();
    String fileName = dis.readUTF();
    byte[] bytes = new byte[fileLength];
    dis.readFully(bytes);
    BufferedImage bimage = ImageIO.read(new ByteArrayInputStream(bytes));

    //do some shit with your bufferedimage or whatever

    files[i] = new File(dirPath + "/" + fileName);

    FileOutputStream fos = new FileOutputStream(files[i]);
    BufferedOutputStream bos = new BufferedOutputStream(fos);

    bos.write(bytes, 0, fileLength);

    bos.close();
}

dis.close();