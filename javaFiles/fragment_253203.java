public TreeMap<String, WordOccurrence> countOccurrences(String filePath)
        throws IOException {
    TreeMap<String, WordOccurrence> words = new TreeMap<>();

    File file = new File(filePath);
    BufferedReader reader = new BufferedReader(new InputStreamReader(
            new FileInputStream(file)));
    String line = null;
    int lineNumber = 0;

    while ((line = reader.readLine()) != null) {
        // remove punctuation and normalize to lower-case
        line = line.replaceAll("\\p{P}", "").toLowerCase();
        lineNumber++;
        String[] tokens = line.split("\\s+");
        for (String token : tokens) {

            if (words.containsKey(token)) {
                words.get(token).addOccurrence(lineNumber);
            } else {
                words.put(token, new WordOccurrence(token, lineNumber));
            }
        }
    }

    return words;
}