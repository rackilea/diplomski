public static void executeCommand() {
    try {
        Process p =  Runtime.getRuntime().exec("cmd /c start filename.exe, null, new File("\"C:/Archivos de Programa/DitelCapture/DitelCaptureV4.4\""));
    } catch (Exception e) {
        e.printStackTrace();
    }
}