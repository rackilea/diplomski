File inputFile = new File("wordlist.txt");
    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("TempWordlist.txt", true)));

    File tempFile = new File("TempWordlist.txt");
    String lineToRemove = JOptionPane.showInputDialog(null, "Enter a word to remove");
    Scanner reader = new Scanner(inputFile);

    while (reader.hasNextLine()) {
        String trimmedLine = reader.nextLine().trim();
        if (trimmedLine.equals(lineToRemove))
            continue;

        writer.print(trimmedLine + "\n");
    }

    reader.close();
    writer.close();
    inputFile.delete();
    tempFile.renameTo(inputFile);