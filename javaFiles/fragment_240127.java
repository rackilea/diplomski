String osName     = System.getProperty("os.name").toLowerString();
String dataModel  = System.getProperty("sun.arch.data.model");

boolean isWindows = osName.startsWith("windows");
boolean isLinux   = osName.startsWith("linux"); // or whatever
boolean is32bit   = "32".equals(dataModel);
boolean is64bit   = "64".equals(dataModel);

if(isWindows && is32bit){
    call32BitWindowsLib();
}

//etc.