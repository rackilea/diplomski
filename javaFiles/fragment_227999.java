public interface User32 extends StdCallLibrary {
    User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
    HWND GetParent(HWND hWnd);
    HWND FindWindow(String lpClassName, String lpWindowName);
    HWND SetFocus(HWND hWnd);
    HWND FindWindowEx(HWND hwndParent, HWND hwndChildAfter, String lpszClass, String lpszWindow);
    int GetWindowText(HWND hWnd, char[] lpString, int nMaxCount);
}