public static void main(String...args) {
    try {
        System.out.println("abs path to test.txt : " + new java.io.File("test.txt").getAbsolutePath());
        System.out.println("user home : " + System.getProperty("user.home"));
        System.out.println("user.dir : " + System.getProperty("user.dir"));
        System.out.println("running from : " + new java.io.File(".").getAbsolutePath());

        System.out.println(new java.io.BufferedReader(new java.io.FileReader("test.txt")).readLine());
    } catch (Exception e) {
        System.out.println("Not found");
    }
}