private short ConvertBytes(byte a, byte b, boolean flip){

    ByteBuffer byteBuffer = ByteBuffer.allocate(2);
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    byteBuffer.put(a);
    byteBuffer.put(b);
    short num = byteBuffer.getShort(0);

    //this.Weight = num;
    int num2 = 0x3720 - num;
    if (num2 > -1){
        return (short)num2;
    }
    return 1;
}