public static void main(String[] args) throws Exception {
    ...
    Channel ch = ...;
    for (int i = 0; i < 1000000; i ++) {
        ch.writeAndFlush(String.valueOf(i) + "\r\n");
    }
    ...
}

// And your handler doesn't need an arrayblockingqueue.