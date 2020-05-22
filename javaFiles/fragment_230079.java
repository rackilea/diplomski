byte[][] samples = {
    { -32, -121, -102 },
    { -63, -69 }
};
for(byte[] array: samples) {
    System.out.println("source: "+Arrays.toString(array));
    String string = new String(array, StandardCharsets.UTF_8);
    System.out.println("strictly interpreted: "+string);
    System.out.println("length: "+string.length());
    ByteBuffer bb = ByteBuffer.allocate(array.length+2);
    bb.putShort((short)array.length).put(array);
    ByteArrayInputStream bis = new ByteArrayInputStream(bb.array());
    DataInputStream dis = new DataInputStream(bis);
    string = dis.readUTF();
    System.out.println("sloppily interpreted: "+string);
    System.out.println("length: "+string.length());
    byte[] actual = string.getBytes(StandardCharsets.UTF_8);
    System.out.println("correct sequence: "+Arrays.toString(actual));
    System.out.println();
}