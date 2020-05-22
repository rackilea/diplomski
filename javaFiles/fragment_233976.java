import com.sun.jna.platform.win32.*;

public class Test {

    public static User32.HHOOK hHook;
    public static User32.LowLevelKeyboardProc lpfn;

    public static void main(String[] args) throws Exception {
        WinDef.HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
        lpfn = new User32.LowLevelKeyboardProc() {
            boolean winKey = false;
            public WinDef.LRESULT callback(int nCode, WinDef.WPARAM wParam, WinUser.KBDLLHOOKSTRUCT lParam) {
                if (lParam.vkCode == 0x5B)
                    winKey = (lParam.flags & 0x80) == 0;
                if (lParam.flags == 0 && lParam.vkCode == 0x52 && winKey) {
                    System.out.println("Win-R pressed");
                    return new WinDef.LRESULT(-1);
                }
                return User32.INSTANCE.CallNextHookEx(hHook, nCode, wParam, lParam.getPointer());
            }
        };
        hHook = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, lpfn, hMod, 0);
        if (hHook == null) {
            System.out.println("Unable to set hook");
            return;
        }
        User32.MSG msg = new User32.MSG();
        while (User32.INSTANCE.GetMessage(msg, null, 0, 0) != 0) {
        }
        if (User32.INSTANCE.UnhookWindowsHookEx(hHook))
            System.out.println("Unhooked");
    }
}