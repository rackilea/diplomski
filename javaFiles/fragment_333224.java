ProcessBuilder pb = new ProcessBuilder(
    "D:\\installs\\apache-ant-1.9.2\\bin\\ant.bat", 
    "-v");
pb.redirectError();
// This should point to where your build.xml file is...
pb.directory(new File("C:/"));
try {
    Process p = pb.start();
    InputStream is = p.getInputStream();
    int in = -1;
    while ((in = is.read()) != -1) {
        System.out.print((char) in);
    }
    int exitValue = p.waitFor();
    System.out.println("Exited with " + exitValue);
} catch (Exception ex) {
    ex.printStackTrace();
}