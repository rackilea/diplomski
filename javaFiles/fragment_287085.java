void read(InputStream inputStream) throws IOException {
    try (DataInputStream in = new DataInputStream(inputStream)) {
        byte b = in.readByte();
        if (b != 0x02) {
            throw new IOException("First byte must be STX");
        }
        int aLength = in.readUnsignedShort();
        byte[] message = new byte[aLength - 3]; // aLength == n
        in.readFully(message);

        byte comAdr = message[0];
        byte controlByte = message[1];
        byte status = message[2];
        byte[] data = Arrays.copyOfRange(message, 7 - 3, aLength - 2);
        int crc16 = ((message[aLength - 1] << 8) 
& 0xFF) | (message[aLength - 1] & 0xFF);

        // Alternatively a ByteBuffer may come in handy.
        int crc16 = ByteBuffer.wrap(message)
            .order(ByteOrder.LITTLE_ENDIAN)
            .getShort(aLength - 2) & 0xFF;
        ...
        String s = new String(data, StandardCharsets.UTF_8);
    }
}