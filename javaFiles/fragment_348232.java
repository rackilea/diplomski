public long readUInt32(
      DataInputStream stream
    ) throws IOException
{
    long retVal = stream.readInt( );

    return retVal & 0x00000000FFFFFFFFL;
}