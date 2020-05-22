public static void main(String[] args) {
    String command = "java";
    String parameters = "-jar install.jar -install /home/john/install.properties";
    ProcessBuilder pb = new ProcessBuilder(command, parameters);

    try {
        pb.start();
    } catch (IOException e) {
        e.printStackTrace();
    }
}