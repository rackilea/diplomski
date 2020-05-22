import java.io.Closeable;
import java.io.IOException;

public class Test implements Closeable {
    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub
    }

    public static void main(String[] args) {
        new Test();
    }
}