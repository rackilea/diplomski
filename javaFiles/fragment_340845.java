package test;

import static test.WindowSwitcher.User32DLL.*;
import static test.WindowSwitcher.Kernel32.*;
import static test.WindowSwitcher.Psapi.*;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.PointerByReference;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import sun.awt.shell.ShellFolder;

public class WindowSwitcher
{
    public static void main(String args[])
    {
        new WindowSwitcher();
    }
    public WindowSwitcher()
    {
        JFrame JF = new JFrame("Window Switcher");
        JPanel JP = new JPanel(new GridLayout(0, 1));

        JF.getContentPane().add(JP);

        Vector<WindowInfo> V = getActiveWindows();
        for (int i = 0; i < V.size(); i++)
        {
            final WindowInfo WI = V.elementAt(i);
            JButton JB = new JButton(WI.title);

            if(WI.image != null)
            {
                JB.setIcon(new ImageIcon(WI.image));
            }

            JB.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    SetForegroundWindow(WI.hWnd);
                }
            });

            JP.add(JB);
        }

        JF.setSize(600,50+V.size()*64);
        JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JF.setAlwaysOnTop(true);
        JF.setFocusableWindowState(false);
        JF.setVisible(true);
    }

    private Vector<WindowInfo> getActiveWindows()
    {
        final Vector<WindowInfo> V = new Vector();

        EnumWindows(new WNDENUMPROC()
        {
            public boolean callback(Pointer hWndPointer, Pointer userData)
            {
                HWND hWnd = new HWND(hWndPointer);

                // Make sure the window is visible
                if(IsWindowVisible(hWndPointer))
                {
                    int GWL_EXSTYLE = -20;
                    long WS_EX_TOOLWINDOW = 0x00000080L;

                    // Make sure this is not a tool window
                    if((GetWindowLongW(hWndPointer, GWL_EXSTYLE) & WS_EX_TOOLWINDOW) == 0)
                    {
                        // Get the title bar text for the window (and other info)
                        WindowInfo info = getWindowTitleAndProcessDetails(hWnd);

                        // Make sure the text is not null or blank
                        if(!(info.title == null || info.title.trim().equals("")))
                        {
                            // Get the icon image for the window (if available)
                            info.image = getImageForWindow(info);

                            // This window is a valid taskbar button, add a WindowInfo object to the return vector
                            V.add(info);
                        }
                    }
                }

                return true;
            }
        }, null);

        return V;
    }

    private static final int MAX_TITLE_LENGTH = 1024;
    private WindowInfo getWindowTitleAndProcessDetails(HWND hWnd)
    {
        if(hWnd == null)
            return null;

        char[] buffer = new char[MAX_TITLE_LENGTH * 2];
        GetWindowTextW(hWnd, buffer, MAX_TITLE_LENGTH);
        String title = Native.toString(buffer);

        PointerByReference pointer = new PointerByReference();
        GetWindowThreadProcessId(hWnd, pointer);    //GetForegroundWindow()
        Pointer process = OpenProcess(PROCESS_QUERY_INFORMATION | PROCESS_VM_READ, false, pointer.getValue());
        GetModuleBaseNameW(process, null, buffer, MAX_TITLE_LENGTH);
        String Sprocess = Native.toString(buffer);
        GetModuleFileNameExW(process, null, buffer, MAX_TITLE_LENGTH);
        String SprocessFilePath = Native.toString(buffer);

        return new WindowInfo(title, Sprocess, SprocessFilePath, hWnd, null);
    }

    private Image getImageForWindow(WindowInfo info)
    {
        if(info.processFilePath == null || info.processFilePath.trim().equals(""))
            return null;

        try
        {
            File f = new File(info.processFilePath);

            if(f.exists())
            {
                // https://stackoverflow.com/questions/10693171/how-to-get-the-icon-of-another-application
                // http://www.rgagnon.com/javadetails/java-0439.html
                ShellFolder sf = ShellFolder.getShellFolder(f);
                if(sf != null)
                    return sf.getIcon(true);

                // Image returned using this method is too small!
                //Icon icon = FileSystemView.getFileSystemView().getSystemIcon(f);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static class Psapi
    {
        static
        {
            Native.register("psapi");
        }

        public static native int GetModuleBaseNameW(Pointer hProcess, Pointer hmodule, char[] lpBaseName, int size);

        public static native int GetModuleFileNameExW(Pointer hProcess, Pointer hmodule, char[] lpBaseName, int size);
    }

    static class Kernel32
    {

        static
        {
            Native.register("kernel32");
        }
        public static int PROCESS_QUERY_INFORMATION = 0x0400;
        public static int PROCESS_VM_READ = 0x0010;

        public static native Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, Pointer pointer);
    }

    static class User32DLL
    {
        static
        {
            Native.register("user32");
        }

        public static native int GetWindowThreadProcessId(HWND hWnd, PointerByReference pref);

        public static native int GetWindowTextW(HWND hWnd, char[] lpString, int nMaxCount);

        public static native boolean EnumWindows(WNDENUMPROC lpEnumFunc, Pointer arg);

        public static interface WNDENUMPROC extends com.sun.jna.win32.StdCallLibrary.StdCallCallback
        {
            boolean callback(Pointer hWnd, Pointer arg);
        }

        public static native boolean IsWindowVisible(Pointer hWnd);

        public static native boolean SetForegroundWindow(HWND hWnd);

        public static native int GetWindowLongW(Pointer hWnd, int nIndex);
    }
}
class WindowInfo
{
    String title, process, processFilePath;
    HWND hWnd;
    Image image;

    public WindowInfo(String title, String process, String processFilePath, HWND hWnd, Image image)
    {
        this.title = title;
        this.process = process;
        this.processFilePath = processFilePath;
        this.hWnd = hWnd;
        this.image = image;
    }
}