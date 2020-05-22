public class Win32Process
{
    WinNT.HANDLE handle;
    int pid;

    Win32Process (int pid) throws IOException
    {
        handle = Kernel32.INSTANCE.OpenProcess ( 
                0x0400| /* PROCESS_QUERY_INFORMATION */
                0x0800| /* PROCESS_SUSPEND_RESUME */
                0x0001| /* PROCESS_TERMINATE */
                0x00100000 /* SYNCHRONIZE */,
                false,
                pid);
        if (handle == null) 
            throw new IOException ("OpenProcess failed: " + 
                    Kernel32Util.formatMessageFromLastErrorCode (Kernel32.INSTANCE.GetLastError ()));
        this.pid = pid;
    }

    @Override
    protected void finalize () throws Throwable
    {
        Kernel32.INSTANCE.CloseHandle (handle);
    }

    public void terminate ()
    {
        Kernel32.INSTANCE.TerminateProcess (handle, 0);
    }

    public List<Win32Process> getChildren () throws IOException
    {
        ArrayList<Win32Process> result = new ArrayList<Win32Process> ();
        WinNT.HANDLE hSnap = KernelExtra.INSTANCE.CreateToolhelp32Snapshot (KernelExtra.TH32CS_SNAPPROCESS, new DWORD(0));
        KernelExtra.PROCESSENTRY32.ByReference ent = new KernelExtra.PROCESSENTRY32.ByReference ();
        if (!KernelExtra.INSTANCE.Process32First (hSnap, ent)) return result;
        do {
            if (ent.th32ParentProcessID.intValue () == pid) result.add (new Win32Process (ent.th32ProcessID.intValue ()));
        } while (KernelExtra.INSTANCE.Process32Next (hSnap, ent));
        Kernel32.INSTANCE.CloseHandle (hSnap);
        return result;
    }