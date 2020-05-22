import sun.nio.ch.DirectBuffer;
import sun.misc.Cleaner;
[...]
if (byteBuffer.isDirect()) {
    Cleaner cleaner = ((DirectBuffer) byteBuffer).cleaner();
    cleaner.clean();
}
// move file