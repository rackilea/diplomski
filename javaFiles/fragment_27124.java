// Account for the length of the header
len -= 4;

if(len > 0) {
    System.out.println("Read " + len + " byte packet.");
    byte[] data = new byte[len];
    dataInputStream.readFully(data);