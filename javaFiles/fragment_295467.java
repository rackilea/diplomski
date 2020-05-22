ProcessBuilder pb = new ProcessBuilder("top", "-l", "1");
pb.redirectError();
try {
    Process p = pb.start();
    InputStream is = p.getInputStream();
    int value = -1;
    while ((value = is.read()) != -1) {
        System.out.print(((char)value));
    }
    int exitCode = p.waitFor();
    System.out.println("Top exited with " + exitCode);
} catch (IOException exp) {
    exp.printStackTrace();
} catch (InterruptedException ex) {
    Logger.getLogger(JavaApplication256.class.getName()).log(Level.SEVERE, null, ex);
}