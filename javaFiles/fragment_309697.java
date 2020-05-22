PipedWriter writer = new PipedWriter();
    PipedReader reader = new PipedReader();
    reader.connect(writer);

    strings.stream().forEach(string -> {
        try {
            writer.write(string);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    });