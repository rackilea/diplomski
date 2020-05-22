private void sendAlgorithmFile(SocketChannel client, String filePath) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(8192);
        buffer.clear();

       /*file path like E:\\classes\\Action.class*/
        Path path = Paths.get(filePath);
        FileChannel fileChannel = FileChannel.open(path);
        int bytes = 0;
        int counter = 0;


        do {
            bytes = fileChannel.read(buffer);
            if (bytes <= 0)
                break;
            counter += bytes;
            buffer.flip();
            do {
                bytes -= client.write(buffer);
            } while (bytes > 0);
            buffer.clear();
        } while (true);


        fileChannel.close();

    }