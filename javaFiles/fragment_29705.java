private runOnLinux(int model, int serialNum) { ... }
private runOnWindows(int model, int serialNum) { ... }
private runOnMac(int model, int serialNum) { ... }

// Somewhere in source code...
String os = System.getProperty("os.name").toLowerCase();
if (os.contains("windows")) {
    runOnWindows(model, serialNum);
} else if (os.contains("linux") || os.contains("unix")) {
    runOnLinux(model, serialNum);
} else {
    // Mac!
    runOnMac(model, serialNum);
}