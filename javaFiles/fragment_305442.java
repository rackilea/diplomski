private String getLocalHwProfileGuid() {
   String regKey = "SYSTEM\\ControlSet001\\Control\\IDConfigDB\\Hardware Profiles\\0001";
   return WinRegistry.getString(
       WinRegistry.HKEY_LOCAL_MACHINE,  //HKEY
       regKey,
       "HwProfileGuid");
}