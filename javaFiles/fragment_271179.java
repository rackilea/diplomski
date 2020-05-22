File file = new File("file.txt");
if (file.canRead()) {
    try (FileReader reader = new FileReader(file)) {
        // Open the file
        reader = new FileReader(file);

        // ...read the file...
    }
}