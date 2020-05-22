import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.streams.WriteStream;

import java.io.IOException;
import java.io.OutputStream;

public class OutputWriterStream extends OutputStream {

    public WriteStream writeStream;
    public Runnable closeHandler;

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (off == 0 && len == b.length) {
            writeStream.write(new Buffer(b));
            return;
        }

        byte[] bytes = new byte[len];
        System.arraycopy(b, off, bytes, 0, len);
        writeStream.write(new Buffer(bytes));
    }

    @Override
    public void write(byte[] b) throws IOException {
        writeStream.write(new Buffer(b));
    }

    @Override
    public void close() throws IOException {
        closeHandler.run();
    }
}