import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;

public class LongToShort {

    public static String GetShortPathName(String path) {
        char[] result = new char[256];
        Kernel32.INSTANCE.GetShortPathName(path, result, result.length);
        return Native.toString(result);
    }

    // java LongToShort "C:\Program Files (x86)\Java\jdk1.6.0_45"
    public static void main(String[] args) {
        System.out.println(GetShortPathName(args[0]));
    }
}