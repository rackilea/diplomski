class Test {
    public static void main(String[] args) throws IOException {

        Process prod = new ProcessBuilder("ls").start();
        Process cons = new ProcessBuilder("cat").start();

        // Start feeding cons with output from prod.
        new DataForwarder(prod.getInputStream(), cons.getOutputStream()).start();
    }
}