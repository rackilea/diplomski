String extension = ".7z";
String id = WinRegistry.readString (
    WinRegistry.HKEY_CLASSES_ROOT,                              //HKEY
    extension,                                                  //Key
   "(Default)");                                                //ValueName
String value = WinRegistry.readString (
    WinRegistry.HKEY_CLASSES_ROOT,                              //HKEY
   id+"\\shell\\open\\command",                                 //Key
   "(Default)");                                                //ValueName
System.out.println("Default App = " + value);