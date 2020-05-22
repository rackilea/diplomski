File file = new File("fileChannelTest.log");
    FileOutputStream fos = new FileOutputStream(file);
    FileChannel fileChannel = fos.getChannel();

    ByteBuffer bb1 = ByteBuffer.wrap("This is a log line to test!\n".getBytes());

    ByteBuffer bb2 = ByteBuffer.allocateDirect(bb1.remaining());
    bb2.put(bb1).flip();

    bb2.mark();
    long freeMemory = Runtime.getRuntime().freeMemory();
    for (int i = 0; i < 1000000; i++) {
        bb2.reset();
        fileChannel.write(bb2);
    }
    System.out.println("Memory allocated: " + (freeMemory - Runtime.getRuntime().freeMemory()));