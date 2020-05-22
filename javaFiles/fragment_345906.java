String bits = "01010011011011100110000101110010"
new String(
    ByteBuffer.allocate(4).putInt(
        Integer.parseInt(bits, 2)
    ).array(), 
    StandardCharsets.UTF_8
);