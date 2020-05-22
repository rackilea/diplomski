public void openFile() throws IOException {
    try {
        // Read in the file
        BufferedReader br = new BufferedReader(
                new FileReader(
                new File("before.txt")));

        String currentLine = br.readLine();

        currentLine = currentLine.toLowerCase();
        currentLine = currentLine.replaceAll("[A-Z]", "");
        br.close(); // Close br to prevent resource leak
        writeFile(currentLine);

    }
    // Exception if the file is not in the path specified
    catch (Exception e) {
        System.out.println("Error: File not found");
    }
}

public void writeFile(String text) throws IOException {
    BufferedWriter output  = new BufferedWriter(new FileWriter("/WS3Ex3/after.txt"));
    output.write(text);
    output.close();
}
}