public boolean jambo_loco (int pid)
{

    Kernel32 kernel32 = (Kernel32) Native.loadLibrary(Kernel32.class, W32APIOptions.UNICODE_OPTIONS);
    Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();          

    WinNT.HANDLE snapshot = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
    try  
    {
        int i = 0;

        int size = processEntry.dwSize.intValue();

        while (kernel32.Process32Next(snapshot, processEntry) && i < size) 
        {             
            if (processEntry.th32ProcessID.intValue() == pid)
                return true;
            i++;
        }

    }
    finally 
    {
        kernel32.CloseHandle(snapshot);
    }
    return false;
}