public void addProperty(long id, long value)
{
    LongBuffer oldBuffer = (LongBuffer)getBuffer();
    long newArray[] = new long[oldBuffer.capacity()+2];
    oldBuffer.get(newArray, 0, oldBuffer.capacity());
    newArray[oldBuffer.capacity()-1] = id;
    newArray[oldBuffer.capacity()+0] = value;
    newArray[oldBuffer.capacity()+1] = 0;
    setBuffer(LongBuffer.wrap(newArray));
}