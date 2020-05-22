ProcessBuilder pb = new ProcessBuilder("C:/Test.bat");
pb.redirectError();
try {
    Process p = pb.start();
    try (InputStream inputStream = p.getInputStream()) {
        int in = -1;
        while ((in = inputStream.read()) != -1) {
            System.out.print((char)in);
        }
    }
    System.out.println("Exited with " + p.waitFor());
} catch (IOException | InterruptedException ex) {
    ex.printStackTrace();
}