@Override
public void write(byte[] raw, int offset, int length) throws IOException
{
    // write to the stream as we encrypt, not all at once.
    final byte[] inBuffer = new byte[Constants.ByteBufferSize];
    final byte[] outBuffer = new byte[Constants.ByteBufferSize];
    int readStart = offset;
    // read into inBuffer, encrypt into outBuffer and write to output stream
    while(readStart<length)
    {
        int readAmount = Math.min(length-readStart, inBuffer.length);
        System.arraycopy(raw, readStart, inBuffer, 0, readAmount);
        readStart+=readAmount;
        int c2 = this.bufferedCipher.processBytes(inBuffer, 0, readAmount, outBuffer, 0);
        this.os.write(outBuffer, 0, c2);
    }
}