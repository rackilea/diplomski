CharBuffer  c;
    ByteBuffer bb = ByteBuffer.allocate(11);    
     System.out.println("Server allocated a number of 11 octets to ByteBuffer");

    socketChannel.read(bb);
    bb.flip();//sets the Position to 0 and limit to the number of bytes to be read.
    CharBuffer c = Charset.forName("ISO-8859-1").decode(bb);
           System.out.println("Got " + c);

    byte[] byteArray = new byte[11];
    bb.get(byteArray);
    System.out.println("Server got from client the string: " +new String(byteArray));
    String an = new String(byteArray);
     bb.clear();