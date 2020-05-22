public static void Option2Method() throws IOException {

    File inputFile = new File("wordlist.txt");
    FileWriter fstream = new FileWriter("TempWordlist.txt", true);
    BufferedWriter writer = new BufferedWriter(fstream);

    File tempFile = new File("TempWordlist.txt");
    String lineToRemove = JOptionPane.showInputDialog(null, "Enter a word to remove");
    Scanner reader = new Scanner(inputFile);

    while (reader.hasNextLine()) {
        String trimmedLine = reader.nextLine().trim();
        if (trimmedLine.equals(lineToRemove))
            continue;

        writer.write(trimmedLine + "\n");
    }

    reader.close();
    writer.close();
    inputFile.delete();
    tempFile.renameTo(inputFile);
}