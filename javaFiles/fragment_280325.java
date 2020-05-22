public static void main(String[] args) throws IOException {
    String commandHeader = "HED>";

    // a 128-byte command
    String command = "0123456789ABCDEF"
            + "0123456789ABCDEF"
            + "0123456789ABCDEF"
            + "0123456789ABCDEF"
            + "0123456789ABCDEF"
            + "0123456789ABCDEF"
            + "0123456789ABCDEF"
            + "0123456789ABCDEF";

    // Convert characters to bytes, and do so with a specified charset
    // Note that ALL Java implementations are required to support UTF-8
    byte[] commandHeaderBytes = commandHeader.getBytes("UTF-8");
    byte[] commandBytes = command.getBytes("UTF-8");

    // Measure the command length in bytes, since that's what the receiver
    // will need to know
    int commandLength = commandHeaderBytes.length + commandBytes.length;

    // Build the whole message in your ByteBuffer
    // Allow a 4-byte length field, per spec
    ByteBuffer bb = ByteBuffer.allocate(commandLength + 4);

    bb.putInt(commandLength)
            .put(commandHeaderBytes)
            .put(commandBytes);

    // DO NOT convert to a String or other character type.  Output the
    // bytes directly.
    System.out.write(bb.array());

    System.out.println();
}