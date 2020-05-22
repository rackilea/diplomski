public static List<String> getFileContentAsList(String fileName) {
    File f = new File(fileName);
    try {
        return Files.readAllLines(f.toPath());
    } catch (IOException e) {
        e.printStackTrace();
    }

    return Collections.emptyList();
}