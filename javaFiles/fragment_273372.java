public static void killProcess(String processName) {
    // PLEASE NOTE: This method will currently Kill "ALL" 
    //              open processes of the supplied process 
    //              name unless commented code changes are 
    //              made.
    try {
        Runtime rt = Runtime.getRuntime();
        // For Windows OS...
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            rt.exec("taskkill /T /F /IM " + processName);
            //rt.exec("taskkill /T /F /PID " + Long.parseLong(processName)); // Supply the PID value as string
            //rt.exec("taskkill /F /FI \"WINDOWTITLE eq " + processName + "\" /T"); // Supply the window title bar text.
            // If you want to kill only a single instance of the 
            // named process then get its PID value and use:
            // "taskkill /T /F /PID PID_Value"  OR you can provide
            // the window title and use:
            // "taskkill /F /FI \"WINDOWTITLE eq " + processName + "\" /T"
        }
        // For OSX And Linux OS's...
        else {
            rt.exec("sudo killall -9 '" + processName + "'");
            //rt.exec("kill -9 " + Long.parseLong(processName)); // Supply the PID value as string
            // If you want to kill only a single instance of the 
            // named process then get its PID value and use:
            // "kill -9 PID_Value"
        }
        rt.freeMemory();
    } 
    catch (IOException | SecurityException | IllegalArgumentException ex) {
        ex.printStackTrace();
    }
}