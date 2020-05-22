public static void Writer() {

    File file = new File("data.txt");
    try (BufferedWriter wr = new BufferedWriter(new FileWriter(
            file.getAbsoluteFile(), true))) { // Creates a writer object
                                                // called wr
                                                // file.getabsolutefile
                                                // takes the filename and
                                                // keeps on storing the old
                                                // data

        System.out.println(" enter what you want to teach me");
        Scanner Keyboard = new Scanner(System.in);
        String lines = Keyboard.nextLine();
         wr.write(lines);
        wr.write("\n");

        wr.newLine();

        wr.close();
    } catch (IOException e) {
        System.out.println(" cannot write to file " + file.toString());
    }


}