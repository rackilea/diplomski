if (selectionKey.isReadable()) {
    int len = inChannel.read(buf);
    System.out.println(len);
    . . .
    buf.flip();
    // ... read from buf ...
    buf.compact();
}