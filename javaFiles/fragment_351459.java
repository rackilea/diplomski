public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("path\\to\\your\\file.txt")));
    BufferedWriter writer = new BufferedWriter(new FileWriter(new File("path\\to\\your\\second\\file.txt")));
    //read one line from your file
    String line = reader.readLine();
    //write something to your file
    writer.write(line);
}