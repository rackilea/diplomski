for (int i = 0; i < 1000000; i ++) {
    ChannelFuture f = ch.writeAndFlush(String.valueOf(i) + "\r\n");
    if ((i + 1) % 100 == 0) {
        // Wait until the write request is actually finished
        // so that the event queue becomes empty.
        f.sync();  
    }
}