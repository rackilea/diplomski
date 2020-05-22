static Pointer setbooleanArray(boolean [] input) {
    Pointer output = new Memory(input.length*Native.getNativeSize(Byte.TYPE));
    for (int i=0;i<input.length;i++){
        output.setByte(i, (byte) (input[i] ? 1:0));
    };
    return output;
};