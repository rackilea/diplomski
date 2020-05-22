public static void main(String[] args) {
    File output = new File("Master-Part1.txt");
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
        findAndAppend(new File("."), bw);
    } catch (IOException exp) {
        exp.printStackTrace();
    }
}