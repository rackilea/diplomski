public static void main(String[] args) throws Exception {
    String nodeValue = "i am mostafa";

    // you want to output to file
    // BufferedWriter writer = new BufferedWriter(new FileWriter(file3, true));
    // but let's print to console while debugging
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] words = nodeValue.split(" ");
    for (String word: words) {
        writer.write(word);
        writer.newLine();
    }
    writer.close();
}