public static void main(String[] args) throws IOException {
    List<File> files = Arrays.asList(
            newTempFile(Arrays.asList("hello", "world")),
            newTempFile(Arrays.asList("english", "java", "programming")),
            newTempFile(Arrays.asList("american", "scala", "stackoverflow"))
    );

    Iterator<String> sortedElements = new MergeFiles<>(files, line -> line).getSortedElements();
    while (sortedElements.hasNext()) {
        System.out.println(sortedElements.next());
    }
}

private static File newTempFile(List<String> words) throws IOException {
    File tempFile = File.createTempFile("sorted-", ".txt");
    Files.write(tempFile.toPath(), words);
    tempFile.deleteOnExit();
    return tempFile;
}