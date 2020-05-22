public static HashMap<Integer, String> fileToHashMap(String fileToRead) throws FileNotFoundException {
    Scanner reader = new Scanner(new File(fileToRead));
    int lineCount = 0;
    HashMap<Integer, String> poemLines = new HashMap<>();
    try {
        while (reader.hasNextLine()) {
            lineCount++;
            String fileLine = reader.nextLine();
            // If you do not want to add blank lines to the
            // collection then uncomment the following lines;
            /*
            if (fileLine.trim().equals("")) {
                continue;
            }
            */
            poemLines.put(lineCount, fileLine); // Add to Collection
        }
    }
    finally {
        reader.close();
    }
    return poemLines;
}