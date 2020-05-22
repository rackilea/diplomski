public static String getContent (File file) throws IOException {
    FileReader fileReader = new FileReader(file);
    String content = IOUtils.toString(fileReader);
    fileReader.close();
    return content;
}