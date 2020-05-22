import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

public class Main {

    public static void main(String[] args) throws Exception {
        Advapi32Util.registrySetStringValue(WinReg.HKEY_CURRENT_USER, "Software\\Chromium", "lastrun", "13031598735788802");
    }
}