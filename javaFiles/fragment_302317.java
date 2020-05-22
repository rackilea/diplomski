private long transferFromArbitraryChannel(ReadableByteChannel src,
                                          long position, long count)
    throws IOException
{
    // Untrusted target: Use a newly-erased buffer
    int c = (int)Math.min(count, TRANSFER_SIZE);
    ByteBuffer bb = Util.getTemporaryDirectBuffer(c);
    long tw = 0;                    // Total bytes written
    long pos = position;
    try {
        Util.erase(bb);
        while (tw < count) {
            bb.limit((int)Math.min((count - tw), (long)TRANSFER_SIZE));
            // ## Bug: Will block reading src if this channel
            // ##      is asynchronously closed
            int nr = src.read(bb);
            if (nr <= 0)
                break;
            bb.flip();
            int nw = write(bb, pos);
            tw += nw;
            if (nw != nr)
                break;
            pos += nw;
            bb.clear();
        }
        return tw;
    } catch (IOException x) {
        if (tw > 0)
            return tw;
        throw x;
    } finally {
        Util.releaseTemporaryDirectBuffer(bb);
    }
}