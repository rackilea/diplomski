// a map of word to translation
Map<String, String> wordMap = new HashMap<String, String>();

// a class that can read a file (we wrap the file reader in a buffered reader because it's more efficient to read a file in chunks larger than a single character)
BufferedReader fileReader = new BufferedReader(new FileReader("my-file.txt"));

// a line from the file
String line;

// read lines until we read a line that is null (i.e. no more lines)
while((line = fileReader.getLine()) != null) {
    // split the line, returns an array of parts
    String[] parts = line.split(",");

    // store the parts in meaningful variables
    String word = parts[0];
    String translation = parts[1];

    // now, store the word and the translation in the word map
    wordMap.put(word, translation);
}

// close the reader (note: you should do this with a try/finally block so that if you throw an exception, you still close the reader)
fileReader.close();