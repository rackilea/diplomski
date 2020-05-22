import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.WPARAM;

public class JNAMonitorTrigger {
    public void monitor(LPARAM param) {
        User32.INSTANCE.PostMessage(WinUser.HWND_BROADCAST,
            WinUser.WM_SYSCOMMAND,
            new WPARAM(0xf170), param);
    }
    public void on() {
        monitor(new LPARAM(-1));
    }

    public void off() {
        monitor(new LPARAM(2));
    }

    public static void main(String args[]) throws Exception {
        JNAMonitorTrigger me = new JNAMonitorTrigger();
        me.off();
        Thread.sleep(1000);
        me.on();
    }
};