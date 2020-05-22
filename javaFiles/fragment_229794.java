public static void main(String[] args) throws InterruptedException, IOException {
    int i = 0, count = 0;
    File source = new File("error.txt");
    File dest = new File("criteria.txt");
    OutputStream output = new FileOutputStream(dest);
    while (i < 15) {
        copyFileUsingStream(source, output);
        if (i < 15) {
            count++;
        }
        i++;
    }
    System.out.println(count);
}

private static void copyFileUsingStream(File source, OutputStream output) 
  throws IOException {
    InputStream input = null;
    try {
        input = new FileInputStream(source);
        byte[] buf = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buf)) > 0) {
            output.write(buf, 0, bytesRead);
        }
    } catch (Exception e) {
        System.out.println("File not found exception");
    }
}