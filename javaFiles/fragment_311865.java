public static void main(String[] args) throws Exception {
        System.out.println("This will be printed");

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        try (CaptureOutput co = new CaptureOutput(stream)) {
            System.out.println("EXAMPLE");
        }

        System.out.println("This will be printed, too.");

        System.out.println("The content of the string is " + stream.toString());
    }