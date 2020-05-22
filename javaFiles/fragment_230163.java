String filePath = "hello.exe";
if (new File(filePath).exists()) {
    try {

        ProcessBuilder pb = new ProcessBuilder(filePath);
        pb.redirectError();
        Process p = pb.start();
        InputStream is = p.getInputStream();
        int value = -1;
        while ((value = is.read()) != -1) {
            System.out.print((char) value);
        }

        int exitCode = p.waitFor();

        System.out.println(filePath + " exited with " + exitCode);
    } catch (Exception e) {
        e.printStackTrace();
    }
} else {
    System.err.println(filePath + " does not exist");
}