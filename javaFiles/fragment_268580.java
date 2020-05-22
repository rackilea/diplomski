ByteBuffer buffer = ByteBuffer.allocate(100);
    // read data into buffer
    buffer.rewind();
    buffer.order(ByteOrder.LITTLE_ENDIAN);
            // 0xf and co mask off sign extension -> handle byte as unsigned
    int type = (buffer.get() >> 4) & 0xf; 
    int origin = buffer.getShort() & 0xffff;
    int receiver = buffer.getShort() & 0xffff;
    // and so on