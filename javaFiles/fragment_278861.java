import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.IntByReference;

/** WINAPI CONSTANTS **/
private static final int RDW_UPDATENOW = 0x0100;

/**
* Redraws all windows associated with currently running process.
*/
public static void redrawApplicationWindows() {
    final int processId = Kernel32.INSTANCE.GetCurrentProcessId();
    User32.INSTANCE.EnumWindows(
        new WinUser.WNDENUMPROC() {
          @Override
          public boolean callback(WinDef.HWND hwnd, Pointer pointer) {
            IntByReference someProcessId = new IntByReference();
            User32.INSTANCE.GetWindowThreadProcessId(hwnd, someProcessId);
            if (someProcessId.getValue() == processId) {
              User32.INSTANCE.RedrawWindow(hwnd, null, null, new User32.DWORD(RDW_UPDATENOW));
            }
            return true;
          }
        }, Pointer.NULL);
}