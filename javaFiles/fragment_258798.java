final WinDef.HWND[] windowHandle = new WinDef.HWND[1];
User32.INSTANCE.EnumWindows(new WinUser.WNDENUMPROC() {
    @Override
    public boolean callback(WinDef.HWND hwnd, Pointer pointer) {
        if (matches(hwnd)) {
            windowHandle[0] = hwnd;
            return false;
        }
        return true;
    }
}, Pointer.NULL);

// Minimize or maximize windowHandle[0] here...