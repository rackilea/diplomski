public static void main(String[] args) {
    byte[] payload = toArray(-1991249);
    int number = fromArray(payload);
    System.out.println(number);
}

public static  int fromArray(byte[] payload){
    ByteBuffer buffer = ByteBuffer.wrap(payload);
    buffer.order(ByteOrder.BIG_ENDIAN);
    return buffer.getInt();
}

public static byte[] toArray(int value){
    ByteBuffer buffer = ByteBuffer.allocate(4);
    buffer.order(ByteOrder.BIG_ENDIAN);
    buffer.putInt(value);
    buffer.flip();
    return buffer.array();
}