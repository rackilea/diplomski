public class Test extends ByteArrayInputStream {
    public Test(byte[] buf) {
        super(buf);
    }

    public Test(byte[] buf, int offset, int length) {
        super(buf, offset, length);
    }
}