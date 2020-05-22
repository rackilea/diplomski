public static void main(String[] args) throws IOException {

    int size; // using it for first line
    int rows; // using it for second line
    int cols; // using it for third line
    // pass the path to the file as a parameter
    BufferedReader fr = new BufferedReader(
        new FileReader("input1.txt")
    );

    // skipping 3 lines
    fr.readLine();
    fr.readLine();
    fr.readLine();

    String line = fr.readLine();
    while (line != null) {
        for (char c : line.toCharArray()) {
            System.out.print(c + " ");
        }

        System.out.println();
        line = fr.readLine();
    }
}