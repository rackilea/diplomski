private static class Psapi {
        static { Native.register("psapi"); }
        public static native int GetModuleBaseNameW(Pointer hProcess, Pointer hmodule, char[] lpBaseName, int size);
    }

    private static class Kernel32 {
        static { Native.register("kernel32"); }
        public static int PROCESS_QUERY_INFORMATION = 0x0400;
        public static int PROCESS_VM_READ = 0x0010;
        public static native int GetLastError();
        public static native Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, Pointer pointer);
    }

    private static class User32DLL {
        static { Native.register("user32"); }
        public static native int GetWindowThreadProcessId(WinDef.HWND hWnd, PointerByReference pref);
        public static native WinDef.HWND GetForegroundWindow();
        public static native int GetWindowTextW(WinDef.HWND hWnd, char[] lpString, int nMaxCount);
    }

    private static final int MAX_TITLE_LENGTH = 1024;

    public void nameApplication() {

        Psapi ps = new Psapi();
        Kernel32 kr = new Kernel32();
        User32DLL us = new User32DLL();

        char[] buffer = new char[MAX_TITLE_LENGTH * 2];
        String nameApp;

        us.GetWindowTextW(us.GetForegroundWindow(), buffer, MAX_TITLE_LENGTH);
        System.out.println("Active window title: " + Native.toString(buffer));

        PointerByReference pointer = new PointerByReference();
        us.GetWindowThreadProcessId(us.GetForegroundWindow(), pointer);
        Pointer process = kr.OpenProcess(kr.PROCESS_QUERY_INFORMATION | kr.PROCESS_VM_READ, false, pointer.getValue());
        ps.GetModuleBaseNameW(process, null, buffer, MAX_TITLE_LENGTH);
        System.out.println("Active window process: " + Native.toString(buffer););

    }