public class Whatever {

    private BlockingQueue<byte[]> buffer = new LinkedBlockingQueue<byte[]>();

    public BlockingQueue<byte[]> getBuffer() {
        return buffer;
    }
}