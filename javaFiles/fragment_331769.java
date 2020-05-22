public static void main(String[] args) {
    byte[] payload = toArray(-1991249);
    int number = fromArray(payload);
    System.out.println(number);
}

public static  int fromArray(byte[] payload){
    ByteBuffer buffer = ByteBuffer.wrap(payload);
    buffer.order(ByteOrder.LITTLE_ENDIAN);
    return buffer.getInt();
}

public static byte[] toArray(int value){
    ByteBuffer buffer = ByteBuffer.allocate(4);
    buffer.order(ByteOrder.LITTLE_ENDIAN);
    buffer.putInt(value);
    return buffer.array();
}