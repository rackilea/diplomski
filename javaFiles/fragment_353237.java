public static void main(String... args) {
    try {
        killProcess();
        Runtime.getRuntime().exec("c:\\Temp\\osk.exe");

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

public static void killProcess() throws Exception {
    Runtime rt = Runtime.getRuntime();
    rt.exec("cmd.exe /c taskkill " + "osk.exe").waitFor();
    rt.exec("taskkill /IM " + "osk.exe").waitFor();
}