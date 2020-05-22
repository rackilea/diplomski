// Enjoy the horrible constructor chaining here
try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream("java.gz"))))) {
    out.write("Hello world from Java 1.7!");
    // Make sure everything gets written
    out.flush();
} // Auto out.close() by using the try-catch-with-resources pattern