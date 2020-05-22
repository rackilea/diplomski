final SocketChannel c = SocketChannel.open();
    c.connect(new InetSocketAddress("localhost", 8007));

    final ByteBuffer buf = ByteBuffer.allocate(5);

    // fill Buffer
    buf.put((byte) 0x0);
    buf.put("Test".getBytes(CharsetUtil.UTF_8));
    // Flip buffer
    buf.flip();

    // Write buffer to socket
    while (buf.hasRemaining()) {
        c.write(buf);
    }

    System.out.println("Reading ...");

    // Read 
    buf.flip();
    while (true) {
        int n = c.read(buf);
        if (n < 0) {
            break;
        }
        final String d = new String(buf.array());
        if(!d.isEmpty()) System.out.println("'" + d + "'");
        buf.clear();
    }

    // Finish Programm
    System.out.println("- DONE -");
    c.close();