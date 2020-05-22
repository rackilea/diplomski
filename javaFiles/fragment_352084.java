public static void main(String[] args) throws InterruptedException {
        ShellAPI.SHELLEXECUTEINFO shellExecuteInfo = new ShellAPI.SHELLEXECUTEINFO();
        shellExecuteInfo.lpFile = "C:\\setup.log";
        shellExecuteInfo.nShow = User32.SW_SHOW;
        shellExecuteInfo.fMask = 0x0000000C;
        shellExecuteInfo.lpVerb = "properties";
        if (Shell32.INSTANCE.ShellExecuteEx(shellExecuteInfo)){
            Thread.sleep(3000);
        }
    }