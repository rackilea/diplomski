@Component
public class CloseableBean1 implements Closeable {

    private boolean closed = false;

    @Override
    public void close() throws IOException {
        if(closed) return;   
        outputStream.close();
        closed=true;
    }
}