// For each word in the file
while (stopWordsFile.hasNext()) {
    stopWords.add(stopWordsFile.next().trim().toLowerCase());
}

// Splits strings and stores each word into a list
ArrayList<String> words = new ArrayList<String>();
while (stopWordsFile.hasNext()) {
    words.add(textFile.next().trim().toLowerCase());
}