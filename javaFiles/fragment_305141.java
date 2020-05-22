byte[] buf = { 0x11, 0x45, 0x34, 0x31, 0x21 };
    long result = 0;
    for (int i = 0; i < buf.length; i++) {
        result = result * 100 + (buf[i] >> 4 & 0XF) * 10 + (buf[i] & 0XF);
    }
    System.out.println(result);