// class declaration ...
private static String readFile(String fileName) {
    String data = "";
    try {
        BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
        StringBuilder string = new StringBuilder();
        for (String line = ""; line = in.readLine(); line != null)
            string.append(line).append("\n");
        in.close();
        data = line.toString();
    }
    catch (IOException ioe) {
        System.err.println("Oops: " + ioe.getMessage());
    }
    return data;
}

public int filesContaining(String phrase, String... files) {
    int count = 0;
    for (String file : files) {
        if (readFile(file).contains(phrase))
            count++;
    }
    return count;
}