public static void main(String[] args) throws IOException {
    // find the file in the file system.. probably not a good idea
    File f = new File("images/test.jpg");
    System.out.println(f.getCanonicalPath()+" "+f.exists());
    URL url = Main.class.getResource("/test.jpg");
    System.out.println(url);