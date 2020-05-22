try {
    File file = new File("assets/test.txt");
    Scanner scanner = new Scanner(file);
    scanner.useDelimiter("[.?!]");
    while (scanner.hasNext()) {
        String sentence = scanner.next();
        sentence = sentence.replaceAll("\\r?\\n", " ");
        // uncomment for nicer output
        //line = line.trim();
        System.out.println(sentence);
    }
    scanner.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}