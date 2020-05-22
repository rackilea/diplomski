import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.BufferUtils;
import org.apache.commons.collections.buffer.BoundedFifoBuffer;

public class DataReader {

public static void main(String[] args) {

    Buffer fifo = BufferUtils.synchronizedBuffer(new BoundedFifoBuffer(100));
    int i;
    while (true) {
        try {
            for (i = 0; i <= 100; i++) {
                fifo.add(i);
            }
        } catch (BufferOverflowException e) {
            System.out.println("fifosize = " + fifo.size());
            System.out.println("before fifo = " + fifo.toString());
            fifo.removeAll(fifo);
            System.out.println("afer removeAll fifo size= " + fifo.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

}