public class Split {
private String fileName;
private PrintWriter fileWords;
private PrintWriter fileIndices;

public Split(String fname) {
    fileName = fname;
    if (initFiles()) {
        writeList();
    }
    closeFiles();
}

private boolean initFiles() {
    boolean retval = false;
    try {
        fileWords = new PrintWriter("words-" + fileName, "UTF-8");
        fileIndices = new PrintWriter("indices-" + fileName, "UTF-8");
        retval = true;
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
    return retval;
}

private void closeFiles() {
    if (null != fileWords) {
        fileWords.close();
    }
    if (null != fileIndices) {
        fileIndices.close();
    }
}

private void writeList() {
    String lastWord = null;
    List<String> wordIndices = new ArrayList<String>();
    Path file = Paths.get(fileName);
    Charset charset = Charset.forName("UTF-8");
    try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
        String line = null;
        while ((line = reader.readLine()) != null) {
            int len = line.length();
            if (len > 0) {
                int ind = line.indexOf(' ');
                if (ind > 0 && ind < (len - 1)) {
                    String word = line.substring(0, ind);
                    String indice = line.substring(ind + 1, len);
                    if (!word.equals(lastWord)) {
                        if (null != lastWord) {
                            writeToFiles(lastWord, wordIndices);
                        }
                        lastWord = word;
                        wordIndices = new ArrayList<String>();
                        wordIndices.add(indice);
                    } else {
                        wordIndices.add(indice);
                    }
                }
            }
        }
        if (null != lastWord) {
            writeToFiles(lastWord, wordIndices);                    
        }
    } catch (IOException x) {
        System.err.format("IOException: %s%n", x);
    }
}

private void writeToFiles(String word, List<String> list) {

    boolean first = true;
    fileWords.println(word);
    for (String elem : list) {
        if (first) {
            first = false;
        }
        else {
            fileIndices.print(" ");
        }
        fileIndices.print(elem);

    }
    fileIndices.println();
}