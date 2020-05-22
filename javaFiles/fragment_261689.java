String getBits(byte b)
{
    String result = "";
    for(int i = 0; i < 8; i++)
        result += (b & (1 << i)) == 0 ? "0" : "1";
    return result;
}