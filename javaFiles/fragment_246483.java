public static byte[] MixThingsUp(byte x, byte y)
{
    byte answer1 = (byte) (0x9D ^ x);
    for (int i=0; i<8; i++)
        if ((answer1 & 0x80) == 0x80)
            answer1 = (byte) ((answer1 << 1) ^ 0x26);
        else
            answer1 = (byte) (answer1 << 1);

    byte answer2 = (byte) (answer1 ^ y);
    for (int i=0; i<8; i++)
        if ((answer2 & 0x80) == 0x80)
            answer2 = (byte) ((answer2 << 1) ^ 0x72);
        else
            answer2 = (byte) ((answer2 << 1));

    return new byte[] { answer1, answer2 };
}