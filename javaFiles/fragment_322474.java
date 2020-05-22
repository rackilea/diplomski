void getFileContents(String path, List<String> contents) throws FileNotFoundException, IOException {
    contents.clear();
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
    String line = null;
    while ((line = reader.readLine()) != null) {
        contents.add(line);
    }
}