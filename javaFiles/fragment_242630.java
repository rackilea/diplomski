try {
    Process process = pb.start();
    InputStream is = process.getInputStream();
    int in = -1;
    while ((in = is.read()) != -1) {
        System.out.print((char)in);
    }
    int exitValue = process.waitFor();

    System.out.println("");
    System.out.println("Did exit with " + exitValue);
} catch (IOException | InterruptedException ex) {
    ex.printStackTrace();
}