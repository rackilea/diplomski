public CaptureOutput() {
        this.stream = new ByteArrayOutputStream();
        this.out = System.out;

        System.setOut(new PrintStream(stream));
    }