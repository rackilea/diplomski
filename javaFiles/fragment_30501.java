public static long byteArrayToInt(byte[] b) 
{
    return  (((long) b[3]) & 0xFF) |
            (((long) b[2]) & 0xFF) << 8 |
            (((long) b[1]) & 0xFF) << 16 |
            (((long) b[0]) & 0xFF) << 24;
}