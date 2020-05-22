/**
 * Enables debug privileges for this process, required for OpenProcess() to
 * get processes other than the current user
 */
private static void enableDebugPrivilege() {
    HANDLEByReference hToken = new HANDLEByReference();
    boolean success = Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(),
            WinNT.TOKEN_QUERY | WinNT.TOKEN_ADJUST_PRIVILEGES, hToken);
    if (!success) {
        LOG.error("OpenProcessToken failed. Error: {}" + Native.getLastError());
        return;
    }
    WinNT.LUID luid = new WinNT.LUID();
    success = Advapi32.INSTANCE.LookupPrivilegeValue(null, WinNT.SE_DEBUG_NAME, luid);
    if (!success) {
        LOG.error("LookupprivilegeValue failed. Error: {}" + Native.getLastError());
        return;
    }
    WinNT.TOKEN_PRIVILEGES tkp = new WinNT.TOKEN_PRIVILEGES(1);
    tkp.Privileges[0] = new WinNT.LUID_AND_ATTRIBUTES(luid, new DWORD(WinNT.SE_PRIVILEGE_ENABLED));
    success = Advapi32.INSTANCE.AdjustTokenPrivileges(hToken.getValue(), false, tkp, 0, null, null);
    if (!success) {
        LOG.error("AdjustTokenPrivileges failed. Error: {}" + Native.getLastError());
    }
    Kernel32.INSTANCE.CloseHandle(hToken.getValue());
}