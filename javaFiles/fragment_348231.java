public void writeUInt32(
      long uint32,
      DataOutputStream stream
    ) throws IOException
{
    stream.writeInt( (int) uint32 );
}