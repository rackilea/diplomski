import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.platform.win32.WinReg.HKEY;
import com.sun.jna.platform.win32.WinReg.HKEYByReference;
import com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;
import com.sun.jna.win32.W32APIOptions;

interface MyAdvapi32 extends StdCallLibrary {
    MyAdvapi32 INSTANCE = (MyAdvapi32) Native.loadLibrary(
        "advapi32",
        MyAdvapi32.class,
        W32APIOptions.DEFAULT_OPTIONS
    );

    int RegConnectRegistry(String machineName, HKEY hKey, HKEYByReference result);
    int RegCloseKey(HKEY key);
}