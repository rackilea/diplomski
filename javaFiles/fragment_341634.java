import com.sun.jna.Library;
import com.sun.jna.Native;

public class ChmodTest {
    private static LinkedOSLibrary linkedLibrary = 
        (LinkedOSLibrary ) Native.loadLibrary("c", LinkedOSLibrary.class);

    public static void main(String[] args) {
        linkedLibrary.chmod("/path/to/file", 0755);
    }
}

interface LinkedOSLibrary extends Library {
    public int chmod(String path, int mode);
}