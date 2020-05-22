private void readFile(File file) {
    List<String> lines = new ArrayList<String>();
    List<String> firstWord = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            // Adds the entire first line
            lines.add(sCurrentLine);
            // Adds the first word
            firstWord.add(sCurrentLine.split(" ")[0]);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}