public void readFile(String absoluteFilePath){
    ByteBuffer buf = ByteBuffer.allocate(2+4+8) // creating a buffer that is suited for data you are reading
    Path path = Paths.get(absoluteFilePath);

    try(FileChannel fileChannel = (FileChannel)Files.newByteChannel(path,Enum.setOf(READ))){
        while(true){
            int bytesRead = fileChannel.read(buf);
            if(bytesRead==-1){
                break;
            }
            buf.flip(); //get the buffer ready for reading.
            char c = buf.asCharBuffer().readChar(); // create a view buffer and read char
            buf.position(buf.position() + 2); //now, lets go to the int
            int i = buf.asIntBuffer().readInt(); //read the int
            buf.position(buf.position()+ 4); //now, lets go for the double.
            double d = buf.asDoubleBuffer().readDouble();
            System.out.println("Character: " + c + " Integer: " + i + " Double: " + d);
            buf.clear();
        }
    }catch(IOException e){
        e.printStackTrace();
    }// AutoClosable so no need to explicitly close
}