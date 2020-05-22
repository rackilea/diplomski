byte[] data = new byte[7];

    data[0] = "{".getBytes()[0];
    data[1] = "{".getBytes()[0];
    data[2] = (byte) 0xd1;
    data[3] = (byte) 0x00;
    data[4] = (byte) 0xd1 + 0x00;
    data[5] = "}".getBytes()[0];
    data[6] = "}".getBytes()[0];