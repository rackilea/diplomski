public static byte[] intToByteArray(int a)
{
    byte[] ret = new byte[4];
    ret[3] = (byte) (a & 0xFF);   
    ret[2] = (byte) ((a >> 8) & 0xFF);   
    ret[1] = (byte) ((a >> 16) & 0xFF);   
    ret[0] = (byte) ((a >> 24) & 0xFF);
    return ret;
}