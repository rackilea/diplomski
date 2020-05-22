public static void main(String[] args) throws IOException,  InterruptedException, ExecutionException {
    final InputStream inputStream = new FileInputStream("/home/me/Store/largefile");
    final ReadableByteChannel inputChannel = Channels.newChannel(inputStream);
    final AsynchronousFileChannel outputChannel = AsynchronousFileChannel.open(
                    FileSystems.getDefault().getPath(
                    "/home/me/Store/output"),
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    outputChannel.lock();

    final ByteBuffer buffer = ByteBuffer.allocate(4096);
    int position = 0;
    int recievedBytes = 0;
    Future<Integer> lastWrite = null;

    while ((recievedBytes = inputChannel.read(buffer)) >= 0
            || buffer.position() != 0) {
        System.out.println("Recieved bytes: " + recievedBytes);
        System.out.println("Buffer position: " + buffer.position());
        buffer.flip();
        lastWrite = outputChannel.write(buffer, position);
        // do extra work while asynchronous channel is writing bytes to disk,
        // in perfect case more extra work can be done, not just simple calculations
        position += recievedBytes;
        // extra work is done, we should wait, because we use only one buffer which can be still busy
        if (lastWrite != null)  lastWrite.get();
        buffer.compact();
    }

    outputChannel.close();
    inputChannel.close();
    inputStream.close();
}