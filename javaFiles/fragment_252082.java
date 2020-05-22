import com.sun.jna.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

static interface Kernel32 extends Library {

    public static Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);

    public int GetProcessId(Long hProcess);
}

public static void main(String[] args) {
    try {
        Process p;

        if (Platform.isWindows())
            p = Runtime.getRuntime().exec("cmd /C ping msn.de");
        else if (Platform.isLinux())
            p = Runtime.getRuntime().exec("cmd /C ping msn.de");

        System.out.println("The PID: " + getPid(p));

        int x = p.waitFor();
        System.out.println("Exit with exitcode: " + x);

    } catch (Exception ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public static int getPid(Process p) {
    Field f;

    if (Platform.isWindows()) {
        try {
            f = p.getClass().getDeclaredField("handle");
            f.setAccessible(true);
            int pid = Kernel32.INSTANCE.GetProcessId((Long) f.get(p));
            return pid;
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else if (Platform.isLinux()) {
        try {
            f = p.getClass().getDeclaredField("pid");
            f.setAccessible(true);
            int pid = (Integer) f.get(p);
            return pid;
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else{}
    return 0;
}
}