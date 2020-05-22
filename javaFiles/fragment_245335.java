try { 
  String value = WinRegistry.readString(WinRegistry.HKEY_LOCAL_MACHINE, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", "TestValue", WinRegistry.KEY_WOW64_64KEY);
  System.out.println(value);
} catch (Exception ex) {
  ex.printStackTrace(); 
}