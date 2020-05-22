String hex = "6174656ec3a7c3a36f";                                  // AAA
ByteBuffer buff = ByteBuffer.allocate(hex.length()/2);
for (int i = 0; i < hex.length(); i+=2) {
    buff.put((byte)Integer.parseInt(hex.substring(i, i+2), 16));
}
buff.rewind();
Charset cs = Charset.forName("UTF-8");                              // BBB
CharBuffer cb = cs.decode(buff);                                    // BBB
System.out.println(cb.toString());                                  // CCC