const int X25_INIT_CRC = 0xffff;

public static ushort crc_accumulate(byte b, ushort crc)
{
    unchecked
    {
        byte ch = (byte)(b ^ (byte)(crc & 0x00ff));
        ch = (byte)(ch ^ (ch << 4));

        return (ushort)((crc >> 8) ^ (ch << 8) ^ (ch << 3) ^ (ch >> 4));
    }
}

public static ushort crc_calculate(byte[] pBuffer)
{
    ushort crcTmp = X25_INIT_CRC;

    for (int i = 1; i < pBuffer.Length; i++) // skips header U
        crcTmp = crc_accumulate(pBuffer[i], crcTmp);

    return crcTmp;
}