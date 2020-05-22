public enum OsType {
    OS(null,null),
        Windows(OS,"Win"),
            WindowsNT(Windows,"WinNT"),
                WindowsNTWorkstation(WindowsNT,"WinNTWorkStation")
....
private OsType parent = null;
private String desc = null;

private OsType(OsType parent,String desc) {
    this.parent = parent;
    this.desc   = desc;
}