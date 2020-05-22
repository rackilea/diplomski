ArrayList<Byte> result = new ArrayList<Byte>();


    result.add((byte) 0);
    result.add((byte) 2);
    result.add((byte) 0);
    result.add((byte) 1);

    ByteBuffer buffer = ByteBuffer.allocate(result.size());
    for(Byte byt : result) {
        buffer.put(byt);
    }