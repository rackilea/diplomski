ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/C", "start");
processBuilder.directory(new File("C:\\"));
try {
    processBuilder.start();
} catch (IOException e) {
    e.printStackTrace();
}