public boolean isSym(Byte firstByte, Byte secondByte)
{

    for (int i = 0; i< 8 ; i++){
        if (bitAt(firstByte, i) != bitAt(secondByte, 7 - i))
            return false;
    }

    return true;
}

public byte bitAt(byte num, int position)
{
   return (byte)((num >> position) & (byte)1);
}