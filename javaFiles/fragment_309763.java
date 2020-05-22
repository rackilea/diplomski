import java.awt.Component;
import java.awt.Window;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;

public class IconifyUtilityClass
{
    public static void minimize(Window window)
    {
        HWND hWnd = getHWND(window);
        User32dll.INSTANCE.CloseWindow(hWnd); //call CloseWindow with this windows handle
    }

    public static void restore(Window window)
    {
        HWND hWnd = getHWND(window);
        User32dll.INSTANCE.OpenIcon(hWnd); //call OpenIcon with this windows handle
    }

    private interface User32dll extends Library
    {
        User32dll INSTANCE = (User32dll) Native.loadLibrary("user32.dll", User32dll.class);
        boolean OpenIcon(HWND hWnd);
        boolean CloseWindow(HWND hWnd);
    }

    private static HWND getHWND(Component comp)
    {
        return new HWND(Native.getComponentPointer(comp));
    }
}