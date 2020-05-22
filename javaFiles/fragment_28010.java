public void main() throws Exception {
    Terminal commandLine = new Terminal();
    // simply pass "null" as instance
    commandLine.addCommand('h', getClass().getMethod("test", String.class), null);
    commandLine.executeCommand('h', "This is a test");
}

public static void test(String data) {
    System.out.println(data);
}