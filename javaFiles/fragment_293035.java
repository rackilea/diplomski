public static void restart() {
    closeServices();
    System.gc();
    try {
        Runtime.getRuntime().exec("taskkill /F /IM java.exe");
        System.exit(0);
    } catch (Throwable e) {
        Logger.handle(e);
    }    
}