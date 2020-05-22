// --- protocol header --------------------------------
    final byte octet1 = input.getByte(0);
    final byte version = getVersion(octet1);
    final byte p = (byte) ((octet1 & 0x20) >> 5);
    final byte x = (byte) ((octet1 & 0x10) >> 4);
    final byte cc = (byte) ((octet1 & 0x0F));

    //...

    // --- seq --------------------------------------------
    final int seq = (input.getInt() & 0x0000FFFF);
    final int timestamp = input.getInt();
    final int ssrc = input.getInt();