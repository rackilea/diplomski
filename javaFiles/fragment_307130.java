File input = new File("whatever");

byte[] buffer = new byte[8];
List<Long> result = new ArrayList<>();

try (DataInputStream in = new DataInputStream(new FileInputStream(input))) {
    int count = 0;        

    // Note: any trailing bytes are ignored
    while (count < input.length() - 4) {
        in.readFully(buffer, 4, 4);
        result.add(ByteBuffer.wrap(buffer)
                .order(ByteOrder.LITTLE_ENDIAN).getLong());
        count += 4;
    }
}