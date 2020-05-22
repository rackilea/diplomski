FileOutputStream out = new FileOutputStream("test");
    ByteBuffer bbf = ByteBuffer.allocate(4);
    bbf.order(ByteOrder.LITTLE_ENDIAN);
    bbf.putShort((short)1);
    bbf.putShort((short)2);
    out.write(bbf.array());
    out.close();