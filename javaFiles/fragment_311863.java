public static void main(String[] args) throws Exception {
    String content = null;

    System.out.println("This will be printed");

    try (CaptureOutput co = new CaptureOutput()) {
        System.out.println("EXAMPLE");

        content = co.getContent();
    }

    System.out.println("This will be printed, too.");

    System.out.println("The content of the string is " + content);
}