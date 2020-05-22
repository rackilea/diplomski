List<String> lines = new ArrayList<>();
try {
    Scanner in = new Scanner(file);

    while(in.hasNext()) {
        String newLine = in.nextLine();
        lines.add(newLine.replaceAll(args[0], "") + "\n"); // <-- save new-line character
    }

    in.close();

    // save all new lines to input file
    FileWriter fileWriter = new FileWriter(args[1]);
    PrintWriter printWriter = new PrintWriter(fileWriter);
    lines.forEach(printWriter::print);
    printWriter.close();

} catch (IOException ioEx) {
    System.err.println("Error: " + ioEx.getMessage());
}