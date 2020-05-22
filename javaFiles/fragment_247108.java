public void writeStream() throws IOException {
    Writer writer = new FileWriter("outputOne.txt");

    try {
        writer.write(inputContent);
    } finally {
        writer.close();
    }
}