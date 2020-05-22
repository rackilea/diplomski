// replace path with path from your system
    DataInputStream in = new DataInputStream(
        new FileInputStream("/dev/input/by-id/usb-0430_0005-event-kbd"));
    String map = "    abcdefghijlkmnopqrstuvwxyz                                                                                                                                                                                                                                                                ";
    // sizeof(struct timeval) = 16
    byte[] timeval = new byte[16];
    short type, code;
    int value;
    while (true) {
        in.readFully(timeval);
        type = in.readShort();
        code = in.readShort();
        value = in.readInt();
        System.out.printf("%04x %04x %08x %c\n", type, code, value, 
                                                 map.charAt(value>>>24));
    }