public class MultiplexOutputStream
extends FilterOutputStream {
    private final OutputStream[] streams;

    public MultiplexOutputStream(OutputStream stream,
                                 OutputStream... otherStreams) {
        super(stream);
        this.streams = otherStreams.clone();

        for (OutputStream otherStream : otherStreams) {
            Objects.requireNonNull(otherStream,
                "Null OutputStream not permitted");
        }
    }

    @Override
    public void write(int b)
    throws IOException {
        super.write(b);
        for (OutputStream stream : streams) {
            stream.write(b);
        }
    }

    @Override
    public void write(byte[] bytes)
    throws IOException {
        super.write(bytes);
        for (OutputStream stream : streams) {
            stream.write(bytes);
        }
    }

    @Override
    public void write(byte[] bytes,
                      int offset,
                      int length)
    throws IOException {
        super.write(bytes, offset, length);
        for (OutputStream stream : streams) {
            stream.write(bytes, offset, length);
        }
    }

    @Override
    public void flush()
    throws IOException {
        super.flush();
        for (OutputStream stream : streams) {
            stream.flush();
        }
    }

    @Override
    public void close()
    throws IOException {
        super.close();
        for (OutputStream stream : streams) {
            stream.close();
        }
    }
}