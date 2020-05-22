Runtime rt=Runtime.getRuntime();
String file="C:\\Users\\V\\Documents\\diplwmatiki\\SFBs\\SF_Antivalent.xml";
Process p=rt.exec(new String[]{
    "C:\\Windows\\System32\\java.exe", 
    "-jar", 
    "C:\\Users\\V\\Documents\\uppaal-4.0.13-aca\\uppaal-4.0.13\\uppaal.jar", 
    file});