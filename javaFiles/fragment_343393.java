public static final int X25_INIT_CRC = 0xffff;

public static int crc_accumulate(short b, int crc) {
    short ch = (short)((b ^ crc) & 0xff);
    ch = (short)((ch ^ (ch << 4)) & 0xff);

    return ((crc >> 8) ^ (ch << 8) ^ (ch << 3) ^ (ch >> 4)) & 0xffff;
}

public static int crc_calculate(short[] pBuffer) {
    int crcTmp = X25_INIT_CRC;

    for (int i = 1; i < pBuffer.length; i++) // skips header U
        crcTmp = crc_accumulate(pBuffer[i], crcTmp);

    return crcTmp;
}