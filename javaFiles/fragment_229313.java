ByteBuffer buffer = ByteBuffer.allocate(100);

    buffer.putInt(10).putChar(':').putInt(30).putChar(' ');
    buffer.putChar('[').putInt(2).putChar(']').putChar(' ');

    // use a well-defined charset rather than the default one, 
    // which varies from platform to platform
    buffer.put("This is my message to you.".getBytes(StandardCharsets.UTF_8));

    // go back to the beginning of the buffer
    buffer.flip();

    // get all the bytes that have actually been written to the buffer
    byte[] bArray = new byte[buffer.remaining()];
    buffer.get(bArray);

    // recreate a buffer wrapping the saved byte array
    buffer = ByteBuffer.wrap(bArray);
    String original =
        new StringBuilder()
            .append(buffer.getInt())
            .append(buffer.getChar())
            .append(buffer.getInt())
            .append(buffer.getChar())
            .append(buffer.getChar())
            .append(buffer.getInt())
            .append(buffer.getChar())
            .append(buffer.getChar())
            .append(new String(buffer.array(), buffer.position(), buffer.remaining(), StandardCharsets.UTF_8))
            .toString();
    System.out.println("original = " + original);