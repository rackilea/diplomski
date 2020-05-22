public void countFile() {
    BufferedReader reader;
    int counter = 0;
    try {
        reader = new BufferedReader(new FileReader("in.txt"));
        int data;
        while ((data = reader.read()) != -1) {
            char charToSearch = 'A';
            if (charToSearch == (char) data) {
                counter++;
            }
        }
        reader.close();
        System.out.println(counter);
    } catch (IOException ioException) {
        System.err.println("Error Opening File: Terminating");
        System.exit(1);
    }
}