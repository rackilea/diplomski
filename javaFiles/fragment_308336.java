package PACKAGE_NAME;
private boolean myUSBDrive;
public static void main(String[] args) {
    ClassLoader loader = CLASS_NAME.class.getClassLoader()
    if (loader.getResource("PACKAGE_NAME/CLASS_NAME").substring(0,9).equals("/Volumes/")) {
    isMyUSBDrive = true;
    }
    else {
        isMyUSBDrive = false;
    }