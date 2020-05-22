public enum OsType {
    OS(null),
        Windows(OS),
            WindowsNT(Windows),
                WindowsNTWorkstation(WindowsNT),
                WindowsNTServer(WindowsNT),
            Windows2000(Windows),
                Windows2000Server(Windows2000),
                Windows2000Workstation(Windows2000),
            WindowsXp(Windows),
            WindowsVista(Windows),
            Windows7(Windows),
            Windows95(Windows),
            Windows98(Windows),
        Unix(OS) {
                @Override
                public boolean supportsXWindows() {
                    return true;
                }
            },
            Linux(Unix),
            AIX(Unix),
            HpUx(Unix),
            SunOs(Unix),
    ;
    private OsType parent = null;

    private OsType(OsType parent) {
        this.parent = parent;
    }
}