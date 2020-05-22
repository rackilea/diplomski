public CaptureOutput(ByteArrayOutputStream stream) {
        this.stream = stream;
        this.out = System.out;

        System.setOut(new PrintStream(this.stream));
    }