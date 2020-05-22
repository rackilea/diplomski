public static void main(String[] args) throws Exception {
    String text = "Welcome to the mvBASE telnet server.You are connected to line 54 on MILL6JAVA-TRANS";
    byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
    int space = 0;
    for (byte b : bytes) {
        System.out.print(Integer.toHexString(b));
        space++;
        if (space == 16) {
            System.out.println();
            space = 0;
        } else if (space % 2 == 0) {
            System.out.print(" ");
        }
    }
}