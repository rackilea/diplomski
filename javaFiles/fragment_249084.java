public static void main(String[] args) {
    try {
        String tempDir=System.getProperty("java.io.tmpdir");
        String sCourrier ="sahu";
        File file = new File(tempDir+"newfile.txt");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(sCourrier.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }