public ExampleClass(){
    try {
            Attr = Files.readAttributes(Paths.get(""), BasicFileAttributes.class);
    } catch (IOException e) {
            e.printStackTrace();
    }
}