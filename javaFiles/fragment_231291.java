class ByteBuffer {
    this order(ByteOrder order);
}

class MappedByteBuffer extends ByteBuffer {
}

// currently this won't work as ByteBuffer defines order()
MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, fc.size())
                         .order(ByteOrder.nativeOrder());