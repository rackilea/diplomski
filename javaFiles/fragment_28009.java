public void test(String data) {
    System.out.println(data);
}

public void main() throws Exception {
    Terminal commandLine = new Terminal();
    // #text() will be called from "this" instance
    commandLine.addCommand('h', getClass().getMethod("test", String.class), this);
    commandLine.executeCommand('h', "This is a test");
}