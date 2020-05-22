List<ByteBuffer> bbs = new ArrayList(list.size());
    int size = 0;
    for (String elt : list)
    {
        ByteBuffer bb = ByteBufferUtil.bytes(elt);
        bbs.add(bb);
        size += 2 + bb.remaining();
    }

    ByteBuffer result = ByteBuffer.allocate(2 + size);
    result.putShort((short)list.size());
    for (ByteBuffer bb : bbs)
    {
        result.putShort((short)bb.remaining());
        result.put(bb.duplicate());
    }
    return (ByteBuffer)result.flip();