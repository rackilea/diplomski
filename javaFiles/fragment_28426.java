public static void main(String[] args) throws FileNotFoundException {

    String word = args[0];

    Scanner input = new Scanner(new File(args[1]));

    // Let's loop through each line of the file
    while (input.hasNext()) {
        String line = input.nextLine();

        // Now, check if this line contains our keyword. If it does, print the line
        if (line.contains(word)) {
            System.out.println(line);
        }
    }
}