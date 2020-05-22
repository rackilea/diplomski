public static final String PACKAGE_ROOT = "org.example.application";

public static void displayStackStraceArray(StackTraceElement[] stackTraceElements) { 
    for (StackTraceElement elem : stackTraceElements) {
        if (elem.getClassName().startsWith(PACKAGE_ROOT)) {
            System.err.println("\t"+elem.toString());
        }
    }
}