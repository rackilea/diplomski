public static void main(String[] args) {
    try {
        Runtime.getRuntime().exec("c:\\executable.exe");
        Runtime.getRuntime().exec("cmd /c c:\\batch_file.bat");
    } catch (IOException e) {
    }
}