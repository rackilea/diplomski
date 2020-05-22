import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.LONG;
import com.sun.jna.platform.win32.WinUser.INPUT;
import java.awt.MouseInfo;
import java.awt.Point;

public class Mouse {

    public static final int MOUSEEVENTF_MOVE = 1;

    public static void _winEvent_mi_move(int x, int y) {
        mouseAction(x, y, MOUSEEVENTF_MOVE);
    }

    public static void mouseAction(int x, int y, int flags) {
        INPUT input = new INPUT();
        input.type = new DWORD(INPUT.INPUT_MOUSE);
        input.input.setType("mi");
        if (x != -1) {
            input.input.mi.dx = new LONG(x);
        }
        if (y != -1) {
            input.input.mi.dy = new LONG(y);
        }
        input.input.mi.time = new DWORD(0);
        input.input.mi.dwExtraInfo = new ULONG_PTR(0);
        input.input.mi.dwFlags = new DWORD(flags);
        User32.INSTANCE.SendInput(new DWORD(1), new INPUT[]{input}, input.size());
    }

    public static void forceMove(int x, int y) {
        init_abs_move_0_0:
        {
            Point ip = MouseInfo.getPointerInfo().getLocation();
            _winEvent_mi_move(-ip.x, -ip.y);
        }
        moveX:
        {
            while (MouseInfo.getPointerInfo().getLocation().x < x - 1) {
                _winEvent_mi_move(1, 0);
            }
        }
        moveY:
        {
            while (MouseInfo.getPointerInfo().getLocation().y < y - 1) {
                _winEvent_mi_move(0, 1);
            }
        }
        System.out.println(MouseInfo.getPointerInfo().getLocation().toString());
    }

    public static void main(String[] args) {
        forceMove(1000, 1000);
        forceMove(2000, 1500);
    }

}