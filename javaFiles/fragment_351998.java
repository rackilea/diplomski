public static void main(String... args) {
    try {
        new A().run();
    } catch (ExitProgramException e) {
        System.exit(e.getCode());
    }
}